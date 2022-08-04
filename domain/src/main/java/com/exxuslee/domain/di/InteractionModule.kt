package com.exxuslee.domain.di

import com.exxuslee.domain.usecases.GetIDUseCase
import org.koin.dsl.module

val interactionModule = module {
    factory<GetIDUseCase.Base> { GetIDUseCase.Base(get()) }
}