package com.example.easymvvmtemplate.presentation.ui.main.search

import android.Manifest
import android.os.Bundle
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
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.DividerItemDecoration.VERTICAL
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.easymvvmtemplate.R
import com.example.easymvvmtemplate.databinding.FragmentMovieSearchBinding
import com.example.easymvvmtemplate.presentation.BaseFragment
import com.example.easymvvmtemplate.presentation.adapter.MovieRVAdapter
import org.koin.android.viewmodel.ext.android.getViewModel

internal class SearchFragment : BaseFragment<SearchViewModel>(), View.OnKeyListener{

    private lateinit var binding: FragmentMovieSearchBinding

    //override val viewModel : SearchViewModel by viewModel<SearchViewModel>()
    //lazy 는 왜 안 되는지 잘 모르겠음
    lateinit var viewModel : SearchViewModel

    private lateinit var movieRVAdapter : MovieRVAdapter


    // 의미 없는 그냥 요청해보기 예제
    private val locationPermissions =
        registerForActivityResult(ActivityResultContracts.RequestMultiplePermissions()) { result ->
            if (result[Manifest.permission.ACCESS_FINE_LOCATION] == true && result[Manifest.permission.ACCESS_COARSE_LOCATION] == true) {
                // 권한을 허용했을 때의 비즈니스 로직 처리
                showToast(R.string.toast_accept_location_permission)
            } else {
                // 권한 거부했을 때의 비즈니스 로직 처리
                showToast(R.string.toast_deny_location_permission)

            }
        }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding =
            DataBindingUtil.inflate(inflater, R.layout.fragment_movie_search, container, false)

        viewModel = getViewModel()
        //viewModel factory 로 만드는 방법?

        binding.viewModel = viewModel
        binding.movieSearchEt.setOnKeyListener(this)

        initRecyclerView()

        observeData()


        // 의미 없는 그냥 요청해보기 예제
        requestLocationPermissions()

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

    private fun fetchMovies(keyword : String) {
        viewModel.fetchMovies(keyword, 20)
    }

    override fun observeData() {
        viewModel.movieListLiveData.observe(viewLifecycleOwner) {
            movieRVAdapter.setMovieList(it)
            //data binding 으로 list 넣는 방법?
        }
        viewModel.noImage.observe(viewLifecycleOwner) {
            binding.searchMovieTv.isVisible = it == true //data binding 으로 넣으면 작동 안 함.
        }
    }



    // 의미 없는 그냥 요청해보기 예제
    private fun requestLocationPermissions() {
        if (checkLocationPermissions().not()) {
            locationPermissions.launch(
                arrayOf(
                    Manifest.permission.ACCESS_COARSE_LOCATION,
                    Manifest.permission.ACCESS_FINE_LOCATION
                )
            )
        }

    }
}