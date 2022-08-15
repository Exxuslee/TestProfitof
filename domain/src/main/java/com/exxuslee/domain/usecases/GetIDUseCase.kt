package com.exxuslee.domain.usecases

import com.exxuslee.domain.models.ID
import com.exxuslee.domain.repositories.IDRepository
import com.exxuslee.domain.utils.Result
import com.exxuslee.domain.utils.Result2

interface GetIDUseCase {
    suspend fun listIDs(): Result2
    suspend fun getID(xxx: Int): Result<ID>

    class Base(private val repository: IDRepository) : GetIDUseCase {

        override suspend fun listIDs(): Result2 =
            repository.listIDs()

        override suspend fun getID(xxx: Int): Result<ID> =
            repository.getID(xxx)
    }
}