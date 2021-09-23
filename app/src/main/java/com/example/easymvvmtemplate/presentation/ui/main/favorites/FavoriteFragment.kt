package com.example.easymvvmtemplate.presentation.ui.main.favorites

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.easymvvmtemplate.R
import com.example.easymvvmtemplate.presentation.BaseFragment

internal class FavoriteFragment : BaseFragment<FavoriteViewModel>() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_favorite, container, false)
    }

    override fun observeData() {

    }
}