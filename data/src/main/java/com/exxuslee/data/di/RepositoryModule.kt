package com.exxuslee.data.di

import com.exxuslee.data.repositories.IDRepositoryImpl
import com.exxuslee.domain.repositories.IDRepository
import org.koin.dsl.module



val repositoryModule = module {
    factory<IDRepository> { IDRepositoryImpl(get(), get()) }
}