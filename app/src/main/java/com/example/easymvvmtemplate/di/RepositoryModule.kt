package com.example.easymvvmtemplate.di

import com.example.easymvvmtemplate.data.repository.MovieRepositoryImpl
import com.example.easymvvmtemplate.domain.repository.MovieRepository
import kotlinx.coroutines.Dispatchers
import org.koin.dsl.module


internal val repositoryModule = module {

    // Dispatchers
    single { Dispatchers.IO }

    single<MovieRepository> { MovieRepositoryImpl(get()) }

}