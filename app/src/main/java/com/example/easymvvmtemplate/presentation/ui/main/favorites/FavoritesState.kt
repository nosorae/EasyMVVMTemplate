package com.example.easymvvmtemplate.presentation.ui.main.favorites

import com.example.easymvvmtemplate.data.local.database.entity.FavoritesEntity


sealed class FavoritesState {
    object UnInitialized: FavoritesState()
    object Loading: FavoritesState()

    data class Success(
        val movies: List<FavoritesEntity>
    ): FavoritesState()

    object Error: FavoritesState()
}