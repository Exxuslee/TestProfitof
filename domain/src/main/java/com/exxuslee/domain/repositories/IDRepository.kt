package com.exxuslee.domain.repositories

import com.exxuslee.domain.models.ID
import com.exxuslee.domain.utils.Result

interface IDRepository {
    suspend fun listIDs(): Result<IntArray>
    suspend fun getID(xxx: Int): Result<ID>
}