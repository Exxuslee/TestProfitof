package com.exxuslee.data.remote.api

import com.exxuslee.data.remote.response.IDResponse
import com.exxuslee.data.remote.response.ListResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path

interface PriceApiService {
    @GET("post/{id}")
    suspend fun getID(@Path("id") id: Int): Response<IDResponse>

    @GET("hot")
    suspend fun getHot(): Response<ListResponse>
}