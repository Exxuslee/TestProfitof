package com.exxuslee.testprofitof.di

import com.exxuslee.testprofitof.ui.IViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val presentationModule = module {
    viewModel { IViewModel(get()) }
}