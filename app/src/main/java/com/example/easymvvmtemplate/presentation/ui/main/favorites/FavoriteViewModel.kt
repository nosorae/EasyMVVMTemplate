package com.example.easymvvmtemplate.presentation.ui.main.favorites

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.easymvvmtemplate.data.repository.MovieRepositoryImpl
import com.example.easymvvmtemplate.presentation.base.BaseViewModel

class FavoriteViewModel(
    private val repositoryImpl: MovieRepositoryImpl
    ) : BaseViewModel() {

    private var _testVar = MutableLiveData<String>()
    val testVar : LiveData<String> get() = _testVar

    fun setTestVar(word : String) {
        _testVar.value = word
    }
    //좋아요 삭제 기능을 넣는다면 two-way data binding 코드로 보여줄 수 있음.

//    fun fetchLikes(keyword: String, display: Int = 30) = viewModelScope.launch {
//
//    }

}