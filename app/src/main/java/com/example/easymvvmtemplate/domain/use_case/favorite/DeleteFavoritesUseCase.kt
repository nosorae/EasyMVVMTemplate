package com.example.easymvvmtemplate.domain.use_case.favorite

import com.example.easymvvmtemplate.domain.repository.FavoritesRepository

class DeleteFavoritesUseCase(
    private val repository: FavoritesRepository
) {
    suspend operator fun invoke(id: Long) {
        repository.deleteFavorites(id)
    }
}