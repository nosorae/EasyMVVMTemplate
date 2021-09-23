package com.example.easymvvmtemplate.presentation.ui.main

import android.Manifest
import android.content.Context
import androidx.activity.result.contract.ActivityResultContracts
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

    private val _movieListLiveData = MutableLiveData<List<MovieEntity>>()
    val movieListLiveData: LiveData<List<MovieEntity>> = _movieListLiveData



     fun fetchMovies(keyword: String, display: Int = 30) = viewModelScope.launch {
         val response = repository.getMovieService(keyword, display)?.let {
             _movieListLiveData.postValue(it.body()?.movieEntities ?: listOf())
         } ?: kotlin.run {
            null
         }

    }




}