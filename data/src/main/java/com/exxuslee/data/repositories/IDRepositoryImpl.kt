package com.exxuslee.data.repositories

import com.exxuslee.data.local.dao.IDDao
import com.exxuslee.data.mapper.IDMapper
import com.exxuslee.data.remote.api.ApiService
import com.exxuslee.domain.models.ID
import com.exxuslee.domain.repositories.IDRepository
import com.exxuslee.domain.utils.Result
import com.exxuslee.domain.utils.Result2

class IDRepositoryImpl(
    private val apiService: ApiService,
    private val IDDao: IDDao,
) : IDRepository {

    override suspend fun listIDs(): Result2 {
        val priceResult = apiService.getHot()
        return if (priceResult.isSuccessful) {
            val remoteData = priceResult.body()
            if (remoteData != null) {
                Result2.Success(remoteData)
            } else Result2.Success(intArrayOf())
        } else Result2.Error("Invalid data/failure")
    }

    override suspend fun getID(getFromRemote: Boolean, xxx: Int): Result<ID> {
        val mapper = IDMapper()
        return when {
            getFromRemote -> {
                val idResult = apiService.getID(id = xxx)
                if (idResult.isSuccessful) {
                    val remoteData = idResult.body()
                    if (remoteData != null) {
                        IDDao.insertID(mapper.remoteToLocal(remoteData, xxx))
                        Result.Success(mapper.remoteToDomain(remoteData))
                    } else {
                        Result.Success(null)
                    }
                } else {
                    Result.Error(Exception("Invalid data/failure"))
                }
            }
            else -> {
                val localData = IDDao.selectID(xxx)
                if (localData == null) {
                    Result.Success(null)
                } else {
                    Result.Success(mapper.localToDomain(localData))
                }
            }
        }
    }
}