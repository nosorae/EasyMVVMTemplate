package com.example.easymvvmtemplate.presentation.ui.main

import android.Manifest
import android.os.Bundle
import com.example.easymvvmtemplate.databinding.ActivityMainBinding
import com.example.easymvvmtemplate.presentation.BaseActivity
import com.example.easymvvmtemplate.presentation.adapter.MainVPAdapter
import com.google.android.material.tabs.TabLayoutMediator
import org.koin.android.viewmodel.ext.android.viewModel

internal class MainActivity : BaseActivity<MainViewModel>() {

    private lateinit var binding: ActivityMainBinding
    override val viewModel: MainViewModel by viewModel() //viewModel 이 필요가 없음.





    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setViewPager()
    }

    private fun setViewPager() = with(binding) {
        mainViewpager.adapter = MainVPAdapter(this@MainActivity)

        val tabNameList = listOf<String>("검색", "좋아요")

        TabLayoutMediator(mainTablayout, mainViewpager) { tab, position ->
            tab.text = tabNameList[position]
        }.attach()
    }





    override fun observeData() = Unit


}