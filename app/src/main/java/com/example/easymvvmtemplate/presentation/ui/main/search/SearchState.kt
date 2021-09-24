package com.example.easymvvmtemplate.presentation.ui.main.search

import com.example.easymvvmtemplate.domain.model.Movie

sealed class SearchState {
    object UnInitialized: SearchState()
    object Loading: SearchState()

    data class Success(
        val movies: List<Movie>
    ): SearchState()

    object Error: SearchState()
}