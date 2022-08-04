package com.exxuslee.data.local.entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.exxuslee.data.utils.Constants


@Entity(tableName = Constants.ID_TABLE)
data class IDEntity(
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "id") val id: Int = 0,
    @ColumnInfo(name = "xxx") val xxx: Int,
    @ColumnInfo(name = "type") val type: String,
    @ColumnInfo(name = "content") val content: String,
)