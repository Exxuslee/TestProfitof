package com.exxuslee.data.local.dao

import androidx.room.*
import com.exxuslee.data.local.entities.IDEntity

@Dao
interface IDDao {

    @Query("UPDATE id_table SET type = :type, content = :content WHERE xxx = :xxx")
    fun setID(xxx: Int, type: String, content: String)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertID(idEntity: IDEntity)

    @Query("SELECT * FROM id_table WHERE xxx = :xxx")
    fun selectID(xxx: Int): IDEntity?


}