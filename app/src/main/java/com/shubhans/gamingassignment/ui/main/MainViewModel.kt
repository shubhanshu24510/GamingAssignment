package com.shubhans.gamingassignment.ui.main

import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import com.shubhans.gamingassignment.repository.CatRepository
import com.shubhans.gamingassignment.utils.Resource
import kotlinx.coroutines.Dispatchers

class MainViewModel(
    private val repository: CatRepository
) : ViewModel() {
    fun getCats() = liveData(Dispatchers.IO) {
        emit(Resource.Loading())
        try {
            val response = repository.getCats()
            if (response.isSuccessful) {
                emit(Resource.Success(response.body() ?: emptyList()))
            } else {
                emit(Resource.Error("Something went wrong"))
            }
        } catch (e: Exception) {
            emit(Resource.Error(e.message ?: "An error occurred"))
        }
    }
}
