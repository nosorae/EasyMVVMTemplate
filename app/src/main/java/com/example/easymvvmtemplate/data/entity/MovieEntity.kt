package com.example.easymvvmtemplate.data.entity



import com.google.gson.annotations.SerializedName


data class MovieEntity(
    @SerializedName("actor")
    val actor: String?,
    @SerializedName("director")
    val director: String?,
    @SerializedName("image")
    val image: String?,
    @SerializedName("link")
    val link: String?,
    @SerializedName("pubDate")
    val pubDate: String?,
    @SerializedName("subtitle")
    var subtitle: String?,
    @SerializedName("title")
    var title: String?,
    @SerializedName("userRating")
    val userRating: String?
)