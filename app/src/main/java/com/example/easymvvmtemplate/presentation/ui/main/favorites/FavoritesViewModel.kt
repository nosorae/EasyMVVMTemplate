package com.example.easymvvmtemplate.presentation.ui.main.favorites

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.example.easymvvmtemplate.data.local.database.entity.FavoritesEntity
import com.example.easymvvmtemplate.domain.use_case.favorite.DeleteFavoritesUseCase
import com.example.easymvvmtemplate.domain.use_case.favorite.GetFavoritesUseCase
import com.example.easymvvmtemplate.presentation.base.BaseViewModel
import kotlinx.coroutines.launch

class FavoritesViewModel(
    private val getFavoritesUseCase: GetFavoritesUseCase,
    private val deleteFavoritesUseCase: DeleteFavoritesUseCase,
) : BaseViewModel() {

    private var _favoritesStateLiveData = MutableLiveData<FavoritesState>(FavoritesState.UnInitialized)
    val favoritesStateLiveData: LiveData<FavoritesState> get() = favoritesStateLiveData


    fun getFavorites() = viewModelScope.launch {
        _favoritesStateLiveData.postValue(FavoritesState.Loading)
        _favoritesStateLiveData.postValue(FavoritesState.Success(getFavoritesUseCase()))
    }
    fun deleteFavorites(id: Long) = viewModelScope.launch {
        _favoritesStateLiveData.postValue(FavoritesState.Loading)
        deleteFavoritesUseCase(id)
        _favoritesStateLiveData.postValue(FavoritesState.Success(getFavoritesUseCase()))
    }

}