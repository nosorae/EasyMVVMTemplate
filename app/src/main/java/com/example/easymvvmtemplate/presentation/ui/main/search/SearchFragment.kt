package com.example.easymvvmtemplate.presentation.ui.main.search

import android.Manifest
import android.os.Bundle
import android.util.Log
import android.view.KeyEvent
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import android.widget.SearchView
import androidx.activity.result.contract.ActivityResultContracts
import androidx.core.view.isVisible
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.DividerItemDecoration.VERTICAL
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.easymvvmtemplate.R
import com.example.easymvvmtemplate.databinding.FragmentMovieSearchBinding
import com.example.easymvvmtemplate.presentation.BaseFragment
import com.example.easymvvmtemplate.presentation.adapter.MovieRVAdapter
import org.koin.android.viewmodel.ext.android.viewModel

class SearchFragment : BaseFragment<SearchViewModel>(), View.OnKeyListener {

    private lateinit var binding: FragmentMovieSearchBinding

    override val viewModel : SearchViewModel by viewModel()
    //lazy 는 왜 안 되는지 잘 모르겠음
//    private lateinit var viewModel: SearchViewModel

    private lateinit var movieRVAdapter: MovieRVAdapter


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        /**
         * viewModel 생성
         */
        //1. Koin 의존성 주입
//        viewModel = getViewModel()

        /*
        2. ViewModelProvider.Factory
        val movieRepository = MovieRepository()
        viewModel = ViewModelProvider(this, MainViewModelFactory(movieRepository)).get(SearchViewModel::class.java)

        movieRepository 를 매번 생성해야 한다 -> 싱글턴의 필요성 -> DI
        */

        /**
         * data binding 연결
         */

        //data binding 이 안 됨.
//        binding = FragmentMovieSearchBinding.inflate(
//            inflater,
//            container,
//            false
//        ).apply {
//            lifecycleOwner = viewLifecycleOwner
//            viewModel = viewModel
//            movieSearchEt.setOnKeyListener(this@SearchFragment)
//        }

        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_movie_search, container, false);
        binding.lifecycleOwner = viewLifecycleOwner //없으면 data binding 안 됨.
        binding.viewModel = viewModel
        binding.movieSearchEt.setOnKeyListener(this@SearchFragment)


        observeData()
        initRecyclerView()

        return binding.root
    }

    private fun initRecyclerView() {
        val viewModel = binding.viewModel
        val decoration = DividerItemDecoration(requireContext(), VERTICAL)

        movieRVAdapter = MovieRVAdapter(viewModel) //ok?
        binding.movieRecyclerView.apply {
            adapter = movieRVAdapter
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

    private fun fetchMovies(keyword: String) {
        viewModel.fetchMovies(keyword, 20)
    }

    override fun observeData() {
//        If the Lifecycle object is not in an active state, then the observer isn't called even if the value changes.
//        After the Lifecycle object is destroyed, the observer is automatically removed.

        viewModel.movieListLiveData.observe(viewLifecycleOwner) {
            movieRVAdapter.setMovieList(it)
            //data binding 으로 list 넣는 방법?
            Log.d("searchFrag", it.toString())
        }
//        viewModel.noImage.observe(viewLifecycleOwner) {
//            binding.searchMovieTv.isVisible = it == true //data binding 으로 넣으면 작동 안 함.
//            Log.d("searchFrag", it.toString())
//        }
    }
}