package com.exxuslee.data.di

import androidx.room.Room
import com.exxuslee.data.local.PriceDatabase
import com.exxuslee.data.utils.Constants.PROFIT_DB
import org.koin.android.ext.koin.androidContext
import org.koin.dsl.module

/**
 * Created by Exxus Lee on 23/07/2020.
 */

val databaseModule = module {
    single {
        Room.databaseBuilder(androidContext(), PriceDatabase::class.java, PROFIT_DB)
            .fallbackToDestructiveMigration().build()
    }

    factory { get<PriceDatabase>().priceDao }
    factory { get<PriceDatabase>().IDDao }
}