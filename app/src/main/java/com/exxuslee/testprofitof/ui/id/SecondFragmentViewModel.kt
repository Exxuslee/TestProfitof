package com.exxuslee.testprofitof.ui.id

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.exxuslee.domain.models.ID
import com.exxuslee.domain.usecases.GetIDUseCase
import com.exxuslee.testprofitof.utils.asLiveData

class SecondFragmentViewModel(private val getIDUseCase: GetIDUseCase.Base) :
    ViewModel() {
    private val _id = MutableLiveData<ID?>()
    val id = _id.asLiveData()

    private val _isLoading = MutableLiveData<Boolean>()
    val isLoading = _isLoading.asLiveData()

    private val _dataFetchState = MutableLiveData<Boolean>()
    val dataFetchState = _dataFetchState.asLiveData()







}