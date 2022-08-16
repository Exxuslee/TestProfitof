package com.exxuslee.testprofitof.ui

import android.os.Bundle
import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.navigation.NavController
import com.exxuslee.domain.models.ID
import com.exxuslee.domain.usecases.GetIDUseCase
import com.exxuslee.domain.utils.HandleResult
import com.exxuslee.domain.utils.Result
import com.exxuslee.testprofitof.R
import com.exxuslee.testprofitof.utils.asLiveData
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class MainViewModel(private val getIDUseCase: GetIDUseCase.Base) : ViewModel() {

    private val _ids = MutableLiveData<IntArray?>()
    val ids = _ids.asLiveData()

    private val _id = MutableLiveData<ID?>()
    val xxx = _id.asLiveData()

    private val _selectedID = MutableLiveData(0)
    val selectedID = _selectedID.asLiveData()

    private val _isLoading = MutableLiveData<Boolean>()
    val isLoading = _isLoading.asLiveData()

    private val _dataFetchState = MutableLiveData<Boolean>()
    val dataFetchState = _dataFetchState.asLiveData()

    fun remoteList() {
        _isLoading.postValue(true)
        viewModelScope.launch {
            val handleResult = object : HandleResult<IntArray> {
                override fun handleError(message: String) {
                    _isLoading.postValue(false)
                    _dataFetchState.postValue(false)
                }

                override fun handleSuccess(data: Any?) {
                    _isLoading.postValue(false)
                    _dataFetchState.postValue(true)
                    _ids.postValue(data as IntArray)
                }

            }
            withContext(Dispatchers.IO) {
                getIDUseCase.listIDs().handle(handleResult)
            }
        }
    }


    fun selectID(id: Int) {
        _selectedID.postValue(id)
    }

    fun pressButton(direction: Boolean) {
        var cur = _selectedID.value
        if (cur != null) {
            if (direction) cur += 1 else cur -= 1
            if (cur >= _ids.value?.size!!) cur = 0
            if (cur < 0) cur = _ids.value?.size!! - 1
            _selectedID.postValue(cur)
            loadID(_ids.value!![cur])
            Log.d(TAG, "${_ids.value!![cur]} ${_id.value} ${_selectedID.value}")
        }

    }

    private fun loadID(xxx: Int) {
        _isLoading.postValue(true)
        viewModelScope.launch {
            when (val result =
                withContext(Dispatchers.IO) { getIDUseCase.getID(xxx) }) {
                is Result.Success -> {
                    _isLoading.postValue(false)
                    if (result.data != null) {
                        _dataFetchState.postValue(true)
                        _id.postValue(result.data)
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

    fun navigate(id: ID, navController: NavController, currentFragment: Int) {
        val bundle = Bundle()
        bundle.putString("content", id.content)

        when (currentFragment) {
            R.id.FirstFragment -> {
                if (id.type == "text") navController.navigate(R.id.action_FirstFragment_to_SecondFragment,
                    bundle)
                if (id.type == "webpage") navController.navigate(R.id.action_FirstFragment_to_ThirdFragment,
                    bundle)
            }
            R.id.SecondFragment -> {
                if (id.type == "text") navController.navigate(R.id.action_SecondFragment_to_SecondFragment,
                    bundle)
                if (id.type == "webpage") navController.navigate(R.id.action_SecondFragment_to_ThirdFragment,
                    bundle)
            }
            R.id.ThirdFragment -> {
                if (id.type == "text") navController.navigate(R.id.action_ThirdFragment_to_SecondFragment,
                    bundle)
                if (id.type == "webpage") navController.navigate(R.id.action_ThirdFragment_to_ThirdFragment,
                    bundle)
            }
            else -> {
                throw Exception("Unknown currentFragment")
            }
        }
    }

    companion object {
        const val TAG = "testProfit"
    }
}