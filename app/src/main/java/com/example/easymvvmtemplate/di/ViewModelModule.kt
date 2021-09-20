package com.example.easymvvmtemplate.di

import com.example.easymvvmtemplate.presentation.ui.MainViewModel
import org.koin.android.experimental.dsl.viewModel
import org.koin.android.viewmodel.dsl.viewModel
import org.koin.dsl.module


internal val viewModelModule = module {
    viewModel { MainViewModel(get()) }
}