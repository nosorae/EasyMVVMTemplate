package com.example.easymvvmtemplate.data.repository

import com.example.easymvvmtemplate.data.local.database.dao.FavoritesDao
import com.example.easymvvmtemplate.data.local.database.entity.FavoritesEntity
import com.example.easymvvmtemplate.domain.repository.FavoritesRepository
import kotlinx.coroutines.flow.Flow

class FavoritesRepositoryImpl(
    private val dao: FavoritesDao
) : FavoritesRepository {
    override suspend fun getFavorites(): List<FavoritesEntity> {
        return dao.getAll()
    }

    override suspend fun insertFavorites(favorites: FavoritesEntity) {
        dao.insert(favorites)
    }

    override suspend fun deleteFavorites(id: Long) {
        dao.delete(id)
    }

}