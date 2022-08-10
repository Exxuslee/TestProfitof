package com.exxuslee.testprofitof.di

import com.exxuslee.testprofitof.ui.FragmentViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val presentationModule = module {
    viewModel { FragmentViewModel(get()) }
}