package com.example.easymvvmtemplate.data.repository

import android.util.Log
import com.example.easymvvmtemplate.data.remote.movie.dto.MovieDto
import com.example.easymvvmtemplate.data.remote.movie.MovieApi
import com.example.easymvvmtemplate.domain.repository.MovieRepository
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.withContext

class MovieRepositoryImpl(
    private val movieApi: MovieApi
) : MovieRepository {

    override suspend fun getMovies(keyword: String, display: Int): MovieDto {
        Log.d("state", "MovieRepositoryImpl")
        return movieApi.getMovies(keyword, display)
    }
}

