package com.example.easymvvmtemplate.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.easymvvmtemplate.data.repository.MovieRepository
import com.example.easymvvmtemplate.presentation.ui.main.search.SearchViewModel

class MainViewModelFactory (private val movieRepository: MovieRepository) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return if (modelClass.isAssignableFrom(SearchViewModel::class.java)) {
            SearchViewModel(movieRepository) as T
        } else {
            throw IllegalArgumentException()
        }
    }
}