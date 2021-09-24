package com.example.easymvvmtemplate.presentation.ui.main

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Transformations
import androidx.lifecycle.viewModelScope
import com.example.easymvvmtemplate.data.entity.MovieEntity
import com.example.easymvvmtemplate.data.repository.MovieRepository
import com.example.easymvvmtemplate.presentation.BaseViewModel
import kotlinx.coroutines.launch

class MainViewModel(
    private val repository: MovieRepository
): BaseViewModel() {

    private val _movieListLiveData = MutableLiveData<List<MovieEntity>>().apply { value = emptyList() }
    val movieListLiveData: LiveData<List<MovieEntity>> get() = _movieListLiveData

    val noImage : LiveData<Boolean> = Transformations.map(_movieListLiveData) {
        // This LiveData depends on another so we can use a transformation.
        //_movieListLiveData 가 변할 때 마다 noImage value 가 변함.
        it.isEmpty()
    }

    fun fetchMovies(keyword: String, display: Int = 30) = viewModelScope.launch {
        val response = repository.getMovieService(keyword, display)?.let {
            _movieListLiveData.postValue(it.body()?.movieEntities ?: listOf())
            Log.d("searchViewModel", "$it")
            //liveData value 변경되면 등록된 observer 가 트리거된다.
        }
    }
    fun onMovieItemClicked(movie : MovieEntity) {
        Log.d("searchViewModel", "${movie.title} clicked!")
        //좋아요 등록? 또는 상세페이지 로직.
    }


}