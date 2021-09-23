package com.example.easymvvmtemplate.presentation.adapter

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.fragment.app.FragmentManager
import androidx.lifecycle.Lifecycle
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.example.easymvvmtemplate.presentation.ui.main.favorites.FavoriteFragment
import com.example.easymvvmtemplate.presentation.ui.main.search.SearchFragment

class MainVPAdapter(fa : FragmentActivity) : FragmentStateAdapter(fa) {

    override fun getItemCount(): Int = 2

    override fun createFragment(position: Int): Fragment {
        return when(position){
            0 -> SearchFragment()
            else -> FavoriteFragment()
        }
    }
}