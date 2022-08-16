package com.exxuslee.data.repositories

import com.exxuslee.data.local.dao.IDDao
import com.exxuslee.data.mapper.IDMapper
import com.exxuslee.data.remote.api.ApiService
import com.exxuslee.domain.models.ID
import com.exxuslee.domain.repositories.IDRepository
import com.exxuslee.domain.utils.Result

class IDRepositoryImpl(
    private val apiService: ApiService,
    private val IDDao: IDDao,
) : IDRepository {

    override suspend fun listIDs(): Result<IntArray> {
        val priceResult = apiService.getHot()
        return if (priceResult.isSuccessful) {
            val remoteData = priceResult.body()
            if (remoteData != null) {
                Result.Success(remoteData)
            } else Result.Success(intArrayOf())
        } else Result.Error("Invalid data/failure")
    }

    override suspend fun getID(xxx: Int): Result<ID> {
        val mapper = IDMapper()
        val localData = IDDao.selectID(xxx)
        if (localData != null) {
            return Result.Success(mapper.localToDomain(localData))
        } else {
            val idResult = apiService.getID(id = xxx)
            return if (idResult.isSuccessful) {
                val remoteData = idResult.body()
                if (remoteData != null) {
                    IDDao.insertID(mapper.remoteToLocal(remoteData, xxx))
                    Result.Success(mapper.remoteToDomain(remoteData))
                } else {
                    Result.Error("Invalid data/failure")
                }
            } else {
                Result.Error("Invalid data/failure")
            }
        }
    }
}