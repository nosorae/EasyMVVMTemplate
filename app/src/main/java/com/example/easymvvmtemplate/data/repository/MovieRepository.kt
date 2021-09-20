package com.example.easymvvmtemplate.data.repository

import com.example.easymvvmtemplate.data.remote.movie.MovieDTO
import com.example.easymvvmtemplate.data.remote.movie.MovieService
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.withContext
import retrofit2.Response

class MovieRepository(
    private val movieService: MovieService,
    private val ioDispatcher: CoroutineDispatcher
): Repository {

    suspend fun getMovieService(keyword: String, display: Int): Response<MovieDTO>? = withContext(ioDispatcher) {
        movieService.getMovieList(keyword, display)
    }


}