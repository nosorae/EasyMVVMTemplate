package com.example.easymvvmtemplate.data.local.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.easymvvmtemplate.data.local.database.dao.FavoritesDao
import com.example.easymvvmtemplate.data.local.database.entity.FavoritesEntity


@Database(
    entities = [FavoritesEntity::class],
    version = 1,
    exportSchema = false
)
abstract class FavoritesDatabase: RoomDatabase() {
    abstract fun movieDao(): FavoritesDao
}