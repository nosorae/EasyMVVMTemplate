package com.example.easymvvmtemplate.presentation.ui.main.favorites

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import com.example.easymvvmtemplate.R
import com.example.easymvvmtemplate.databinding.FragmentFavoriteBinding
import com.example.easymvvmtemplate.presentation.BaseFragment
import org.koin.android.ext.android.bind
import org.koin.android.viewmodel.ext.android.getViewModel

class FavoriteFragment : BaseFragment<FavoriteViewModel>() {

    private lateinit var binding : FragmentFavoriteBinding
    override lateinit var viewModel: FavoriteViewModel
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