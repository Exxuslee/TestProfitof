package com.exxuslee.data.repositories

import com.exxuslee.data.local.dao.CurrencyDao
import com.exxuslee.data.local.dao.PriceDao
import com.exxuslee.data.local.entities.PriceEntity
import com.exxuslee.data.mapper.CurrencyMapper
import com.exxuslee.data.mapper.PriceMapper
import com.exxuslee.data.remote.api.PriceApiService
import com.exxuslee.domain.models.ID
import com.exxuslee.domain.models.IDs
import com.exxuslee.domain.repositories.IDRepository
import com.exxuslee.domain.utils.Result

class IDRepositoryImpl(
    private val PriceApi: PriceApiService,
    private val PriceDao: PriceDao,
    private val CurrencyDao: CurrencyDao,
) : IDRepository {

    override suspend fun listIDs(getFromRemote: Boolean): Result<IDs> {
        TODO("Not yet implemented")
    }

    override suspend fun getID(getFromRemote: Boolean): Result<ID> {
        TODO("Not yet implemented")
    }
}