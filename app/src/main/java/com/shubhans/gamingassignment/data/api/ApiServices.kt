package com.shubhans.gamingassignment.data.api

import com.shubhans.gamingassignment.data.model.Cat
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {
    @GET("images/search")
    suspend fun getCats(
        @Query("limit") limit: Int = 10
    ): Response<List<Cat>>
}