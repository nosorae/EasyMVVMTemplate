package com.example.easymvvmtemplate.presentation.base

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

internal abstract class BaseActivity<VM: BaseViewModel>: AppCompatActivity() {
    abstract val viewModel: VM


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        observeData()
    }

    abstract fun observeData()


    internal fun showToast(stringResourceId: Int) {
        Toast.makeText(this, getString(stringResourceId), Toast.LENGTH_SHORT).show()
    }


}