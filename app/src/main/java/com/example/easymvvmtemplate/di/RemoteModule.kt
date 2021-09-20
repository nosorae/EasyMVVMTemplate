package com.example.easymvvmtemplate.di

import com.example.easymvvmtemplate.data.remote.Url
import com.example.easymvvmtemplate.data.remote.movie.MovieService
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import org.koin.android.BuildConfig
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

internal val remoteModule = module {


    single { provideMovieRetrofit() }
    single { provideMovieService(get()) }

}

internal fun provideMovieRetrofit(): Retrofit =
    Retrofit.Builder()
        .baseUrl(Url.NAVER_API_URL)
        .addConverterFactory(GsonConverterFactory.create(GsonBuilder().setLenient().create()))
        .client(buildOkHttpClient())
        .build()

internal fun provideMovieService(retrofit: Retrofit) =
    retrofit.create(MovieService::class.java)


internal fun buildOkHttpClient(): OkHttpClient {
    val interceptor = HttpLoggingInterceptor()
    if(BuildConfig.DEBUG) {
        interceptor.level = HttpLoggingInterceptor.Level.BODY
    } else {
        interceptor.level = HttpLoggingInterceptor.Level.NONE
    }
    return OkHttpClient.Builder()
        .connectTimeout(5, TimeUnit.SECONDS)
        .addInterceptor(interceptor)
        .build()
}