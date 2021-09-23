package com.example.easymvvmtemplate.presentation.ui.main.favorites

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Transformations
import androidx.lifecycle.viewModelScope
import com.example.easymvvmtemplate.data.entity.MovieEntity
import com.example.easymvvmtemplate.data.repository.MovieRepository
import com.example.easymvvmtemplate.presentation.BaseViewModel
import kotlinx.coroutines.launch

class FavoriteViewModel(
    private val repository: MovieRepository
    ) : BaseViewModel() {

    private val _likeListLiveData = MutableLiveData<List<MovieEntity>>().apply { value = emptyList() }
    val likeListLiveData: LiveData<List<MovieEntity>> get() = _likeListLiveData

    val noLike : LiveData<Boolean>
        get() = Transformations.map(_likeListLiveData){
        it.isEmpty()
    }

    //좋아요 삭제 기능을 넣는다면 two-way data binding 코드로 보여줄 수 있음.

//    fun fetchLikes(keyword: String, display: Int = 30) = viewModelScope.launch {
//
//    }

}