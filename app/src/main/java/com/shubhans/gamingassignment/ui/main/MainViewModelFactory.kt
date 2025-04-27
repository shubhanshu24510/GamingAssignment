package com.shubhans.gamingassignment.ui.main

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.shubhans.gamingassignment.repository.CatRepository

class MainViewModelFactory(
    private val repository: CatRepository
) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return MainViewModel(repository) as T
    }
}
