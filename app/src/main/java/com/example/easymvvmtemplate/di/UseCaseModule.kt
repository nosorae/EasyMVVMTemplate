package com.example.easymvvmtemplate.di

import com.example.easymvvmtemplate.domain.use_case.movies.GetMoviesUseCase
import org.koin.dsl.module


internal val useCaseModule = module {
    factory { GetMoviesUseCase(get()) }
}