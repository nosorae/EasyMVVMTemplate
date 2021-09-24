package com.example.easymvvmtemplate.data.remote.movie.dto


import com.google.gson.annotations.SerializedName

data class MovieDto(
    @SerializedName("display")
    val display: Int?,
    @SerializedName("items")
    val movieItems: List<MovieItem>?,
    @SerializedName("lastBuildDate")
    val lastBuildDate: String?,
    @SerializedName("start")
    val start: Int?,
    @SerializedName("total")
    val total: Int?
)