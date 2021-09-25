package com.example.easymvvmtemplate.domain.model

/**
 * Domain layer 에서 필요한 데이터만 Dto 에서 가져와서 model 로 사용
 */
data class Movie(
    val actor: String?,
    val director: String?,
    val image: String?,
    val link: String?,
    val pubDate: String?,
    var subtitle: String?,
    var title: String?,
    val userRating: String?
)