package com.exxuslee.domain.usecases

import com.exxuslee.domain.models.ID
import com.exxuslee.domain.models.IDs
import com.exxuslee.domain.repositories.IDRepository
import com.exxuslee.domain.utils.Result

interface GetIDUseCase {
    suspend fun listIDs(): Result<IDs>
    suspend fun getID(getFromRemote: Boolean, xxx: Int): Result<ID>

    class Base(private val repository: IDRepository) : GetIDUseCase {

        override suspend fun listIDs(): Result<IDs> =
            repository.listIDs()

        override suspend fun getID(getFromRemote: Boolean, xxx: Int): Result<ID> =
            repository.getID(getFromRemote, xxx)
    }
}