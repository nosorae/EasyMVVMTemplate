package com.example.easymvvmtemplate.presentation.ui.main

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.example.easymvvmtemplate.data.entity.MovieEntity
import com.example.easymvvmtemplate.data.repository.MovieRepository
import com.example.easymvvmtemplate.presentation.BaseViewModel
import kotlinx.coroutines.launch

class MainViewModel(
    private val repository: MovieRepository
): BaseViewModel() {

}