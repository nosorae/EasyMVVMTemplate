package com.example.easymvvmtemplate.presentation

import android.Manifest
import android.content.pm.PackageManager
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat

internal abstract class BaseActivity<VM: BaseViewModel>: AppCompatActivity() {
    abstract val viewModel: VM


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        observeData()
    }

    abstract fun observeData()


    private fun checkFineLocationSelfPermission(): Boolean =
        (ContextCompat.checkSelfPermission(
            this,
            Manifest.permission.ACCESS_COARSE_LOCATION
        ) == PackageManager.PERMISSION_GRANTED) &&
                (ContextCompat.checkSelfPermission(
                    this,
                    Manifest.permission.ACCESS_FINE_LOCATION
                ) == PackageManager.PERMISSION_GRANTED)



    internal fun showToast(stringResourceId: Int) {
        Toast.makeText(this, getString(stringResourceId), Toast.LENGTH_SHORT).show()
    }


}