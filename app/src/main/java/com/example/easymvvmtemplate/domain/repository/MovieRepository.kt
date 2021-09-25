package com.example.easymvvmtemplate.domain.repository

import com.example.easymvvmtemplate.data.remote.dto.MovieDto

/**
 * domain 에 repository interface 를 두는 것의 장점
 * 1. Test 에 용이 (fake 구현체만 바꿔서 주입하면 되므로)
 * 2. Domain 만 봐도 이 앱이 어떤 비즈니스 로직을 수행하는지 한눈에 알아볼 수 있음(?)
 */
interface MovieRepository {
    suspend fun getMovies(keyword: String, display: Int): MovieDto
}