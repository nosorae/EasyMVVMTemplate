package com.example.easymvvmtemplate.presentation.ui.main.search

import android.os.Bundle
import android.util.Log
import android.view.KeyEvent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import androidx.core.view.isGone
import androidx.core.view.isVisible
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.DividerItemDecoration.VERTICAL
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.easymvvmtemplate.R
import com.example.easymvvmtemplate.databinding.FragmentMovieSearchBinding
import com.example.easymvvmtemplate.domain.model.Movie
import com.example.easymvvmtemplate.presentation.adapter.MovieRVAdapter
import com.example.easymvvmtemplate.presentation.base.BaseFragment
import org.koin.android.viewmodel.ext.android.viewModel

internal class SearchFragment : BaseFragment<SearchViewModel>(), View.OnKeyListener {

    private lateinit var binding: FragmentMovieSearchBinding

    //override val viewModel : SearchViewModel by viewModel<SearchViewModel>()
    //lazy 는 왜 안 되는지 잘 모르겠음
    /**
     * viewModel 생성
     */
    private val viewModel: SearchViewModel by viewModel()

    private lateinit var movieRVAdapter: MovieRVAdapter


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        /**
         * data binding 연결
         */
        binding =
            DataBindingUtil.inflate(inflater, R.layout.fragment_movie_search, container, false)
        binding.lifecycleOwner = viewLifecycleOwner //없으면 data binding 안 됨.
        binding.viewModel = viewModel
        binding.movieSearchEt.setOnKeyListener(this@SearchFragment)



        observeData()

        return binding.root

        /*
        2. ViewModelProvider.Factory
        val movieRepository = MovieRepository()
        viewModel = ViewModelProvider(this, MainViewModelFactory(movieRepository)).get(SearchViewModel::class.java)

        movieRepository 를 매번 생성해야 한다 -> 싱글턴의 필요성 -> DI
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


    }

    /**
     * If the Lifecycle object is not in an active state, then the observer isn't called even if the value changes.
     * After the Lifecycle object is destroyed, the observer is automatically removed.
     */
    override fun observeData() {

        viewModel.searchStateLiveData.observe(viewLifecycleOwner) { state ->
            when (state) {
                is SearchState.UnInitialized -> {
                    initViews()
                }
                is SearchState.Loading -> {
                    handleLoadingState()
                }
                is SearchState.Success -> {
                    handleSuccessState(state.movies)
                }
                is SearchState.Error -> {
                    handleErrorState()
                }
            }
        }


        viewModel.noImage.observe(viewLifecycleOwner) {
            //binding.searchMovieTv.isVisible = it == true //data binding 으로 넣으면 작동 안 함.
            Log.d("searchFrag", it.toString())
        }
    }
    private fun initViews() {
        binding.searchMovieTv.isGone = false
        binding.movieRecyclerView.isGone = true
        initRecyclerView()
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

    private fun handleLoadingState() {
        binding.searchProgressBar.isGone = false
    }

    private fun handleSuccessState(movies: List<Movie>) = with(binding) {
        searchProgressBar.isGone = true
        if (movies.isNullOrEmpty()) {
            searchMovieTv.isGone = false
            movieRecyclerView.isGone = true
        } else {
            searchMovieTv.isGone = true
            movieRecyclerView.isGone = false
            movieRVAdapter.setMovieList(movies)
        }

    }

    private fun handleErrorState() {
        binding.searchProgressBar.isGone = true
        binding.searchMovieTv.isGone = false
        showToast(R.string.toast_api_error)

    }


    override fun onKey(v: View?, keyCode: Int, event: KeyEvent?): Boolean {
        if (keyCode == KeyEvent.KEYCODE_ENTER && event?.action == KeyEvent.ACTION_DOWN) {
            when (v?.id) {
                R.id.movie_search_et -> {
                    getMovies((v as EditText).text.toString())
                }
            }
            return true
        }
        return false
    }

    private fun getMovies(keyword: String) {
        viewModel.getMovies(keyword, 20)
    }



}