package com.exxuslee.data.di

import androidx.room.Room
import com.exxuslee.data.local.IDDatabase
import com.exxuslee.data.utils.Constants.PROFIT_DB
import org.koin.android.ext.koin.androidContext
import org.koin.dsl.module

val databaseModule = module {
    single {
        Room.databaseBuilder(androidContext(), IDDatabase::class.java, PROFIT_DB)
            .fallbackToDestructiveMigration().build()
    }

    factory { get<IDDatabase>().idDao }
}