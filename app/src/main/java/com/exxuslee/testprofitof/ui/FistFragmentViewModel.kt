package com.exxuslee.testprofitof.ui

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.exxuslee.domain.models.IDs
import com.exxuslee.domain.usecases.GetIDUseCase
import com.exxuslee.testprofitof.utils.asLiveData

class FistFragmentViewModel(private val getIDUseCase: GetIDUseCase.Base) : ViewModel() {
    private val _ids = MutableLiveData<IDs?>()
    val ids = _ids.asLiveData()

    private val _isLoading = MutableLiveData<Boolean>()
    val isLoading = _isLoading.asLiveData()

    private val _dataFetchState = MutableLiveData<Boolean>()
    val dataFetchState = _dataFetchState.asLiveData()



}