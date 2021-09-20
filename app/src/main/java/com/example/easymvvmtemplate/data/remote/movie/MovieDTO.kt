package com.example.easymvvmtemplate.data.remote.movie


import com.example.easymvvmtemplate.data.entity.MovieEntity
import com.google.gson.annotations.SerializedName

data class MovieDTO(
    @SerializedName("display")
    val display: Int?,
    @SerializedName("items")
    val movieEntities: List<MovieEntity>?,
    @SerializedName("lastBuildDate")
    val lastBuildDate: String?,
    @SerializedName("start")
    val start: Int?,
    @SerializedName("total")
    val total: Int?
)