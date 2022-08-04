package com.exxuslee.data.local.dao

import androidx.room.*
import com.exxuslee.data.local.entities.IDEntity

/**
 * Created by Exxus Lee on 22/07/2020.
 */

@Dao
interface IDDao {

    @Query("UPDATE currency_table SET base = :base, `check` = :check WHERE xxx = :xxx")
    fun updateCurrency(xxx: String, base: Boolean, check: Boolean)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertCurrency(currency: IDEntity)

    @Query("SELECT * FROM id_table")
    suspend fun getList(): List<IDEntity>?

}