package com.example.easymvvmtemplate.presentation.ui.main.search

import android.util.Log
import android.widget.Toast
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Transformations
import androidx.lifecycle.viewModelScope
import com.example.easymvvmtemplate.data.entity.MovieEntity
import com.example.easymvvmtemplate.data.repository.MovieRepository
import com.example.easymvvmtemplate.presentation.BaseViewModel
import kotlinx.coroutines.launch

class SearchViewModel(
    private val repository: MovieRepository
    ) : BaseViewModel() {

    private val _movieListLiveData = MutableLiveData<List<MovieEntity>>().apply { value = emptyList() }
    val movieListLiveData: LiveData<List<MovieEntity>> get() = _movieListLiveData

    val noImage : LiveData<Boolean> get() = Transformations.map(_movieListLiveData){
        it.isEmpty()
    }

    fun fetchMovies(keyword: String, display: Int = 30) = viewModelScope.launch {
        val response = repository.getMovieService(keyword, display)?.let {
            _movieListLiveData.postValue(it.body()?.movieEntities ?: listOf())
        }
    }
    fun onMovieItemClicked(movie : MovieEntity) {
        Log.d("searchViewModel", "${movie.title} clicked!")
        //좋아요 등록 또는 상세페이지 로직.
    }

}