package com.exxuslee.testprofitof.di

import com.exxuslee.testprofitof.ui.SecondFragmentViewModel
import com.exxuslee.testprofitof.ui.FistFragmentViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val presentationModule = module {
    viewModel { FistFragmentViewModel(get()) }
    viewModel { SecondFragmentViewModel(get()) }
}