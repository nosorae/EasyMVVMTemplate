package com.example.easymvvmtemplate.presentation.ui.main.search

import android.os.Bundle
import android.util.Log
import android.view.KeyEvent
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import androidx.core.view.isVisible
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.DividerItemDecoration.VERTICAL
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.easymvvmtemplate.R
import com.example.easymvvmtemplate.databinding.FragmentMovieSearchBinding
import com.example.easymvvmtemplate.presentation.adapter.MovieAdapter
import org.koin.android.viewmodel.ext.android.getViewModel

internal class SearchFragment : Fragment(), View.OnKeyListener{

    private lateinit var binding: FragmentMovieSearchBinding

    //override val viewModel : SearchViewModel by viewModel<SearchViewModel>()
    //lazy 는 왜 안 되는지 잘 모르겠음
    lateinit var viewModel : SearchViewModel

    private lateinit var movieAdapter : MovieAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding =
            DataBindingUtil.inflate(inflater, R.layout.fragment_movie_search, container, false)

        viewModel = getViewModel<SearchViewModel>()
        //viewModel factory 로 만드는 방법?

        binding.viewModel = viewModel
        binding.movieSearchEt.setOnKeyListener(this)

        initRecyclerView()

        observeData()

        return binding.root
    }

    private fun initRecyclerView() {
        val viewModel = binding.viewModel
        val decoration = DividerItemDecoration(requireContext(), VERTICAL)

        movieAdapter = MovieAdapter(viewModel) //ok?
        binding.movieRecyclerView.apply {
            adapter = movieAdapter
            layoutManager = LinearLayoutManager(requireContext())
            addItemDecoration(decoration)
        }
    }

    override fun onKey(v: View?, keyCode: Int, event: KeyEvent?): Boolean {
        if (keyCode == KeyEvent.KEYCODE_ENTER && event?.action == KeyEvent.ACTION_DOWN) {
            when (v?.id) {
                R.id.movie_search_et -> {
                    fetchMovies((v as EditText).text.toString())
                }
            }
            return true
        }
        return false
    }

    private fun fetchMovies(keyword : String) {
        viewModel.fetchMovies(keyword, 20)
    }

    private fun observeData() {
        viewModel.movieListLiveData.observe(viewLifecycleOwner) {
            movieAdapter.setMovieList(it)
            //data binding 으로 list 넣는 방법?
        }
        viewModel.noImage.observe(viewLifecycleOwner) {
            binding.searchMovieTv.isVisible = it == true //data binding 으로 넣으면 작동 안 함.
        }
    }
}