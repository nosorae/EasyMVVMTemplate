package com.example.easymvvmtemplate.domain.use_case.movies

import android.util.Log
import com.example.easymvvmtemplate.common.Resource
import com.example.easymvvmtemplate.data.remote.dto.toMovie
import com.example.easymvvmtemplate.domain.model.Movie
import com.example.easymvvmtemplate.domain.repository.MovieRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class GetMoviesUseCase(
    private val repository: MovieRepository
) {
    operator fun invoke(keyword: String, display: Int): Flow<Resource<List<Movie>>> = flow {
        try {
            emit(Resource.Loading<List<Movie>>())
            Log.d("state", "invoke GetMovieUseCase")
            val movies = repository
                .getMovies(
                    keyword =keyword,
                    display = display
                )
                .movieItems
                ?.map { it.toMovie() }

            emit(Resource.Success<List<Movie>>(movies ?: listOf()))
        } catch (e: Exception) {
            Log.d("state", e.toString())
            emit(Resource.Error<List<Movie>>("Couldn't reach server. Check your internet connection."))
        }
    }
}