package com.example.easymvvmtemplate.domain.use_case.favorite

import com.example.easymvvmtemplate.data.local.database.entity.FavoritesEntity
import com.example.easymvvmtemplate.domain.repository.FavoritesRepository

class GetFavoritesUseCase(
    private val repository: FavoritesRepository
) {
    suspend operator fun invoke(): List<FavoritesEntity> {
        return repository.getFavorites()
    }
}