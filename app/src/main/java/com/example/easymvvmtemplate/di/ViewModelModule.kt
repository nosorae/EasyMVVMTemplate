package com.example.easymvvmtemplate.di

import com.example.easymvvmtemplate.presentation.ui.main.MainViewModel
import com.example.easymvvmtemplate.presentation.ui.main.favorites.FavoritesViewModel
import com.example.easymvvmtemplate.presentation.ui.main.search.SearchViewModel
import org.koin.android.viewmodel.dsl.viewModel
import org.koin.dsl.module


internal val viewModelModule = module {
    viewModel { MainViewModel() }
    viewModel { SearchViewModel(get()) }
    viewModel { FavoritesViewModel(get(), get()) }
}