package com.example.easymvvmtemplate.data.remote

import com.example.easymvvmtemplate.common.Constants
import com.example.easymvvmtemplate.data.remote.dto.MovieDto
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.Query

interface MovieApi {
    @Headers("X-Naver-Client-Id: Y2NAMEqbtiS3rTm5XPPj", "X-Naver-Client-Secret: I02dkZj3c4")
    @GET(Constants.GET_NAVER_MOVIES)
    suspend fun getMovies(
        @Query("query") keyword: String,
        @Query("display") display: Int,
    ): MovieDto
}