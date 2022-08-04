package com.exxuslee.data.local

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.exxuslee.data.local.dao.IDDao
import com.exxuslee.data.local.entities.IDEntity
import com.exxuslee.data.local.typeconverter.Converters


@Database(entities = [IDEntity::class, IDEntity::class], version = 1, exportSchema = false)
@TypeConverters(Converters::class)
abstract class PriceDatabase : RoomDatabase() {
    abstract val IDDao: IDDao
}