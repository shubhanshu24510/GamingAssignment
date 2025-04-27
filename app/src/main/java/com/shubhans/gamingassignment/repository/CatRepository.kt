package com.shubhans.gamingassignment.repository

import com.shubhans.gamingassignment.data.api.RetrofitInstance

class CatRepository {
    suspend fun getCats() = RetrofitInstance.api.getCats()
}