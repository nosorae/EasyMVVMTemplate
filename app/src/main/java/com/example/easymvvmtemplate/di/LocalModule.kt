package com.example.easymvvmtemplate.di

import android.content.Context
import androidx.room.Room
import com.example.easymvvmtemplate.common.Constants
import com.example.easymvvmtemplate.data.local.database.FavoritesDatabase
import org.koin.android.ext.koin.androidApplication
import org.koin.dsl.module

internal val localModule = module {

    single { provideDB(androidApplication()) }
    single { provideToDoDao(get()) }

}


internal fun provideDB(context: Context): FavoritesDatabase =
    Room.databaseBuilder(context, FavoritesDatabase::class.java, Constants.DB_NAME).build()

internal fun provideToDoDao(database: FavoritesDatabase) = database.movieDao()