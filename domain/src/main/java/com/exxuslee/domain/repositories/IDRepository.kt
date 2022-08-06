package com.exxuslee.domain.repositories

import com.exxuslee.domain.models.ID
import com.exxuslee.domain.models.IDs
import com.exxuslee.domain.utils.Result

interface IDRepository {
    suspend fun listIDs(): Result<IDs>
    suspend fun getID(getFromRemote: Boolean, xxx: Int): Result<ID>
}