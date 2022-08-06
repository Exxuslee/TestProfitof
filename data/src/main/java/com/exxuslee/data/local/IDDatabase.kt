package com.exxuslee.data.local

import androidx.room.Database
import androidx.room.RoomDatabase
import com.exxuslee.data.local.dao.IDDao
import com.exxuslee.data.local.entities.IDEntity


@Database(entities = [IDEntity::class], version = 1, exportSchema = false)
abstract class IDDatabase : RoomDatabase() {
    abstract val idDao: IDDao
}