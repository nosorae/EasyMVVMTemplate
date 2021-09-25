package com.example.easymvvmtemplate.data.repository

import android.util.Log
import com.example.easymvvmtemplate.data.remote.dto.MovieDto
import com.example.easymvvmtemplate.data.remote.MovieApi
import com.example.easymvvmtemplate.domain.repository.MovieRepository

class MovieRepositoryImpl(
    private val movieApi: MovieApi
) : MovieRepository {

    override suspend fun getMovies(keyword: String, display: Int): MovieDto {
        Log.d("state", "MovieRepositoryImpl")
        return movieApi.getMovies(keyword, display)
    }
}

