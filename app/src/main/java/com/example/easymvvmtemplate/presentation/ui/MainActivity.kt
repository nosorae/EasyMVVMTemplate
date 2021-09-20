package com.example.easymvvmtemplate.presentation.ui

import android.os.Bundle
import androidx.recyclerview.widget.GridLayoutManager
import com.example.easymvvmtemplate.databinding.ActivityMainBinding
import com.example.easymvvmtemplate.presentation.BaseActivity
import com.example.easymvvmtemplate.presentation.adapter.MovieAdapter
import org.koin.android.viewmodel.ext.android.viewModel

internal class MainActivity : BaseActivity<MainViewModel>() {
    private lateinit var binding: ActivityMainBinding
    private var movieAdapter = MovieAdapter()

    override val viewModel: MainViewModel by viewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        fetchMovies()
        initRecyclerView()
    }

    private fun fetchMovies() {
        viewModel.fetchMovies("winter", 20)
    }

    private fun initRecyclerView() {
        binding.movieRecyclerView.apply {
            adapter = movieAdapter
            layoutManager = GridLayoutManager(this@MainActivity, 2)
        }
    }

    override fun observeData() {
        viewModel.movieListLiveData.observe(this) {
            movieAdapter.setMovieList(it, movieItemClickListener = {})
        }

    }


}