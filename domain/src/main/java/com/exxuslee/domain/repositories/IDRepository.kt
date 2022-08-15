package com.exxuslee.domain.repositories

import com.exxuslee.domain.models.ID
import com.exxuslee.domain.utils.Result
import com.exxuslee.domain.utils.Result2

interface IDRepository {
    suspend fun listIDs(): Result2
    suspend fun getID(xxx: Int): Result<ID>
}