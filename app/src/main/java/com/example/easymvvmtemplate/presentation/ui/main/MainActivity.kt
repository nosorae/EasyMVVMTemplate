package com.example.easymvvmtemplate.presentation.ui.main

import android.os.Bundle
import androidx.activity.result.contract.ActivityResultContracts
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.GridLayoutManager
import com.example.easymvvmtemplate.R
import com.example.easymvvmtemplate.databinding.ActivityMainBinding
import com.example.easymvvmtemplate.presentation.BaseActivity
import com.example.easymvvmtemplate.presentation.adapter.MainVPAdapter
import com.google.android.material.tabs.TabLayoutMediator
import org.koin.android.viewmodel.ext.android.viewModel

internal class MainActivity : BaseActivity<MainViewModel>() {

    private lateinit var binding : ActivityMainBinding
    override val viewModel: MainViewModel by viewModel() //viewModel 이 필요가 없음.


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


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setViewPager()
    }

    private fun setViewPager() = with(binding){
        mainViewpager.adapter = MainVPAdapter(this@MainActivity)
        val tabNameList = listOf<String>("검색", "좋아요")
        TabLayoutMediator(mainTablayout, mainViewpager) { tab, position ->
            tab.text = tabNameList[position]
        }.attach()
    }
    private fun requestLocationPermissions() {
        locationPermissions.launch(
            arrayOf(
                Manifest.permission.ACCESS_COARSE_LOCATION,
                Manifest.permission.ACCESS_FINE_LOCATION
            )
        )
    }

    override fun observeData() = Unit


}