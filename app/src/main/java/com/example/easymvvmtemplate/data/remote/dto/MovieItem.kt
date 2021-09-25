package com.example.easymvvmtemplate.data.remote.dto



import com.example.easymvvmtemplate.domain.model.Movie
import com.google.gson.annotations.SerializedName


data class MovieItem(
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

fun MovieItem.toMovie(): Movie =
    Movie(
        actor = actor,
        director = director,
        image = image,
        link = link,
        pubDate = pubDate,
        subtitle = subtitle,
        title = title,
        userRating = userRating
    )
