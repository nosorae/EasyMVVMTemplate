package com.example.easymvvmtemplate.presentation.ui.main.favorites

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.easymvvmtemplate.R
import com.example.easymvvmtemplate.databinding.FragmentFavoriteBinding
import com.example.easymvvmtemplate.presentation.base.BaseFragment
import org.koin.android.viewmodel.ext.android.viewModel

class FavoriteFragment : BaseFragment<FavoritesViewModel>() {
    /**
     * 아직 View 를 구현하지 못했습니다.
     * 그러나 Room - Repository - UseCase - ViewModel 흐름은 구현해 뒀으니 참고할 수 있습니다.
     */

    private lateinit var binding: FragmentFavoriteBinding
    override val viewModel: FavoritesViewModel by viewModel()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val root = inflater.inflate(R.layout.fragment_favorite, container, false)
        binding = FragmentFavoriteBinding.bind(root)


        return binding.root
    }

    override fun observeData() {
        viewModel.favoritesStateLiveData.observe(viewLifecycleOwner) { state ->
            when (state) {
                is FavoritesState.UnInitialized -> {

                }
                is FavoritesState.Loading -> {

                }
                is FavoritesState.Success -> {

                }
                is FavoritesState.Error -> {

                }
            }
        }

    }
}