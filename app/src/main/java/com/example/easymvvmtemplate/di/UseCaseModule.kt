package com.example.easymvvmtemplate.di

import com.example.easymvvmtemplate.domain.use_case.favorite.DeleteFavoritesUseCase
import com.example.easymvvmtemplate.domain.use_case.favorite.GetFavoritesUseCase
import com.example.easymvvmtemplate.domain.use_case.favorite.InsertFavoritesUseCase
import com.example.easymvvmtemplate.domain.use_case.movies.GetMoviesUseCase
import org.koin.dsl.module


internal val useCaseModule = module {
    factory { GetMoviesUseCase(get()) }

    factory { GetFavoritesUseCase(get()) }
    factory { InsertFavoritesUseCase(get()) }
    factory { DeleteFavoritesUseCase(get()) }
}