package com.example.easymvvmtemplate.presentation

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity

internal abstract class BaseActivity<VM: BaseViewModel>: AppCompatActivity() {
    abstract val viewModel: VM


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        observeData()
    }

    abstract fun observeData()


}