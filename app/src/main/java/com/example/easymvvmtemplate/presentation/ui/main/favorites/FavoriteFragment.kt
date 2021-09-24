package com.example.easymvvmtemplate.presentation.ui.main.favorites

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.easymvvmtemplate.R
import com.example.easymvvmtemplate.databinding.FragmentFavoriteBinding
import com.example.easymvvmtemplate.presentation.base.BaseFragment

internal class FavoriteFragment : BaseFragment<FavoriteViewModel>() {

    private lateinit var binding : FragmentFavoriteBinding
//    private lateinit var viewModel: FavoriteViewModel
    private var testNum = 0
    //aac viewModel 은 하나만 가능하니까 이거는 실행 불가능? -> yes.

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val root = inflater.inflate(R.layout.fragment_favorite, container, false)
//        viewModel = getViewModel()
        binding = FragmentFavoriteBinding.bind(root)
//
//        binding.testBtn.setOnClickListener {
//            viewModel.setTestVar(testNum.toString())
//            testNum++
//        }



        return binding.root
    }

    override fun observeData() {
//        viewModel.testVar.observe(viewLifecycleOwner) {
//            Log.d("favoriteFrag", it)
//            binding.testTv.text = it
//        }
    }
}