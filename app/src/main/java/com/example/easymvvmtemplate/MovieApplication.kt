package com.example.easymvvmtemplate

import android.app.Application
import com.example.easymvvmtemplate.di.*
import com.example.easymvvmtemplate.di.localModule
import com.example.easymvvmtemplate.di.remoteModule
import com.example.easymvvmtemplate.di.repositoryModule
import com.example.easymvvmtemplate.di.useCaseModule
import com.example.easymvvmtemplate.di.viewModelModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

/**
 * 출처 :
 * https://www.youtube.com/watch?v=EF33KmyprEQ&t=751s
 * https://levelup.gitconnected.com/what-is-screaming-architecture-f7c327af9bb2
 */
class MovieApplication: Application() {
    override fun onCreate() {
        super.onCreate()

        startKoin {
            androidContext(this@MovieApplication)
            modules(remoteModule)
            modules(localModule)
            modules(repositoryModule)
            modules(viewModelModule)
            modules(useCaseModule)
        }

    }
}