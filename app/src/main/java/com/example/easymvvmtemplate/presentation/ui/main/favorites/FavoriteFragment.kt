package com.example.easymvvmtemplate.presentation.ui.main.favorites

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.easymvvmtemplate.R
import com.example.easymvvmtemplate.databinding.FragmentFavoritesBinding
import com.example.easymvvmtemplate.presentation.base.BaseFragment
import org.koin.android.viewmodel.ext.android.viewModel

/**
 * 아직 View 를 구현하지 못했습니다.
 * 그러나 Room - Repository - UseCase - ViewModel 흐름은 구현해 뒀으니 참고할 수 있습니다.
 */
internal class FavoriteFragment : BaseFragment<FavoritesViewModel>() {

    private lateinit var binding : FragmentFavoritesBinding
    override val viewModel: FavoritesViewModel by viewModel()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentFavoritesBinding.inflate(layoutInflater)


    }
    override fun observeData() {
        viewModel.favoritesStateLiveData.observe(viewLifecycleOwner) { state ->
            when (state) {
                is FavoritesState.UnInitialized -> {
                    initViews()
                }
                is FavoritesState.Loading -> {
                    handleLoadingState()
                }
                is FavoritesState.Success -> {
                    handleSuccessState()
                }
                is FavoritesState.Error -> {
                    handleErrorState()
                }
            }
        }

    }

    private fun initViews() {

    }

    private fun handleLoadingState() {

    }

    private fun handleSuccessState() {

    }

    private fun handleErrorState() {

    }
}