package com.example.easymvvmtemplate.data.local.database.dao

import androidx.room.*
import com.example.easymvvmtemplate.data.local.database.entity.FavoritesEntity


@Dao
interface FavoritesDao {

    @Query("SELECT * FROM FavoritesEntity") // R
    suspend fun getAll(): List<FavoritesEntity>

    @Insert(onConflict = OnConflictStrategy.REPLACE) // C
    suspend fun insert(movie: FavoritesEntity)



    @Query("DELETE FROM FavoritesEntity WHERE id=:id") // D
    suspend fun delete(id: Long)

}