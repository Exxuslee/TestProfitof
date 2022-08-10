package com.exxuslee.testprofitof.ui

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.navigation.NavController
import com.exxuslee.domain.usecases.GetIDUseCase
import com.exxuslee.domain.utils.Result
import com.exxuslee.testprofitof.R
import com.exxuslee.testprofitof.utils.asLiveData
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class FragmentViewModel(private val getIDUseCase: GetIDUseCase.Base) : ViewModel() {
    private val _ids = MutableLiveData<IntArray?>()
    val ids = _ids.asLiveData()

    private val _selectedID = MutableLiveData<Int?>()
    val selectedID = _selectedID.asLiveData()

    private val _isLoading = MutableLiveData<Boolean>()
    val isLoading = _isLoading.asLiveData()

    private val _dataFetchState = MutableLiveData<Boolean>()
    val dataFetchState = _dataFetchState.asLiveData()

    fun remoteList() {
        _isLoading.postValue(true)
        viewModelScope.launch {
            when (val result =
                withContext(Dispatchers.IO) { getIDUseCase.listIDs() }) {
                is Result.Success -> {
                    _isLoading.postValue(false)
                    if (result.data != null) {
                        _dataFetchState.postValue(true)
                        _ids.postValue(result.data)
                    } else {
                        _dataFetchState.postValue(false)
                    }
                }

                is Result.Error -> {
                    _isLoading.postValue(false)
                    _dataFetchState.postValue(false)
                }
                else -> {}
            }
        }
    }

    fun selectID(id: Int) {
        _selectedID.postValue(id)
    }

    fun navigate(navController: NavController, currentFragment: Int?, direction: Boolean) {
        if (direction) when (currentFragment) {
            R.id.FirstFragment -> {
                navController.navigate(R.id.action_FirstFragment_to_SecondFragment)
            }
            R.id.SecondFragment -> {
                navController.navigate(R.id.action_SecondFragment_to_FirstFragment)
            }
            R.id.ThirdFragment -> {
                navController.navigate(R.id.action_ThirdFragment_to_FirstFragment)
            }
        } else when (currentFragment) {
            R.id.FirstFragment -> {
                navController.navigate(R.id.action_FirstFragment_to_ThirdFragment)
            }
            R.id.SecondFragment -> {
                navController.navigate(R.id.action_SecondFragment_to_FirstFragment)
            }
            R.id.ThirdFragment -> {
                navController.navigate(R.id.action_ThirdFragment_to_FirstFragment)
            }
        }

    }
}