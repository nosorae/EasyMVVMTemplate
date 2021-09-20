package com.example.easymvvmtemplate.di

import com.example.easymvvmtemplate.data.repository.MovieRepository
import kotlinx.coroutines.Dispatchers
import org.koin.dsl.module


internal val repositoryModule = module {

    // Dispatchers
    single { Dispatchers.IO }
    single { Dispatchers.Main }

    single { MovieRepository(get(), get()) }

}