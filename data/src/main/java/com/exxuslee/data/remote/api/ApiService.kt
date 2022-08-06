package com.exxuslee.data.remote.api

import com.exxuslee.data.remote.response.IDResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path

interface ApiService {
    @GET("post/{id}")
    suspend fun getID(@Path("id") id: Int): Response<IDResponse>

    @GET("hot")
    suspend fun getHot(): Response<ArrayList<Int>>
}