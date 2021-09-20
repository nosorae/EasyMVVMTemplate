package com.example.easymvvmtemplate.presentation.ui

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.easymvvmtemplate.data.entity.MovieEntity
import com.example.easymvvmtemplate.data.remote.movie.MovieDTO
import com.example.easymvvmtemplate.data.repository.MovieRepository
import com.example.easymvvmtemplate.presentation.BaseViewModel
import kotlinx.coroutines.launch
import retrofit2.Response

class MainViewModel(
    private val repository: MovieRepository
): BaseViewModel() {

    private val _movieListLiveData = MutableLiveData<List<MovieEntity>>()
    val movieListLiveData: LiveData<List<MovieEntity>> = _movieListLiveData

     fun fetchMovies(keyword: String, display: Int = 30) = viewModelScope.launch {
         val response = repository.getMovieService(keyword, display)?.let {
             _movieListLiveData.postValue(it.body()?.movieEntities ?: listOf())
         }

    }


}