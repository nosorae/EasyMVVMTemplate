package com.example.easymvvmtemplate.di

import com.example.easymvvmtemplate.presentation.ui.main.MainViewModel
import com.example.easymvvmtemplate.presentation.ui.main.favorites.FavoriteViewModel
import com.example.easymvvmtemplate.presentation.ui.main.search.SearchViewModel
import org.koin.android.viewmodel.dsl.viewModel
import org.koin.dsl.module


internal val viewModelModule = module {
    viewModel { MainViewModel() }
    viewModel { SearchViewModel(get()) }
//    viewModel { FavoriteViewModel(get()) }
}