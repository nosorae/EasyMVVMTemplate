package com.example.easymvvmtemplate.presentation.ui.main.search

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Transformations
import androidx.lifecycle.viewModelScope
import com.example.easymvvmtemplate.common.Resource
import com.example.easymvvmtemplate.domain.model.Movie
import com.example.easymvvmtemplate.domain.use_case.movies.GetMoviesUseCase
import com.example.easymvvmtemplate.presentation.base.BaseViewModel
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach

class SearchViewModel(
    private val getMoviesUseCase: GetMoviesUseCase
) : BaseViewModel() {
    //viewModel , lifecycle -> jetpack lifecycle library
    //The purpose of ViewModel is to encapsulate the data for a UI controller to let the data survive configuration changes.

    private val _searchStateLiveData = MutableLiveData<SearchState>(SearchState.UnInitialized)
    val searchStateLiveData: LiveData<SearchState> = _searchStateLiveData

    val noImage: LiveData<Boolean> = Transformations.map(_searchStateLiveData) { state ->
        // This LiveData depends on another so we can use a transformation.
        //_movieListLiveData 가 변할 때 마다 noImage value 가 변함.
        state == SearchState.Error
                || state == SearchState.Success(emptyList())
                || state == SearchState.Loading
    }

    fun getMovies(keyword: String, display: Int) {

        getMoviesUseCase(
            keyword = keyword,
            display = display
        ).onEach { result ->
            when (result) {
                is Resource.Loading -> {
                    _searchStateLiveData.value = SearchState.Loading
                }
                is Resource.Success -> {
                    _searchStateLiveData.value = SearchState.Success(result.data ?: emptyList())
                }
                is Resource.Error -> {
                    _searchStateLiveData.value = SearchState.Error
                }
            }
        }.launchIn(viewModelScope)


    }

    fun onMovieItemClicked(movie: Movie) {
        Log.d("searchViewModel", "${movie.title} clicked!")
        //좋아요 등록? 또는 상세페이지 로직.
    }

}