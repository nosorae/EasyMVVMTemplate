package com.example.easymvvmtemplate.data.remote.movie

import com.example.easymvvmtemplate.data.remote.Url
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.Query

interface MovieService {
    @Headers("X-Naver-Client-Id: Y2NAMEqbtiS3rTm5XPPj", "X-Naver-Client-Secret: I02dkZj3c4")
    @GET(Url.GET_NAVER_MOVIES)
    suspend fun getMovieList(
        @Query("query") keyword: String,
        @Query("display") display: Int,
    ): Response<MovieDTO>
}