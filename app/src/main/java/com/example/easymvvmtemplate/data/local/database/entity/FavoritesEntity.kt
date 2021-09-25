package com.example.easymvvmtemplate.data.local.database.entity

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.easymvvmtemplate.domain.model.Movie

@Entity
data class FavoritesEntity(
    @PrimaryKey(autoGenerate = true) val id: Long = 0,
    val actor: String?,
    val director: String?,
    val image: String?,
    val link: String?,
    val pubDate: String?,
    val subtitle: String?,
    val title: String?,
    val userRating: String?
)

fun FavoritesEntity.toMovie(): Movie =
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

fun Movie.toFavoriteEntity(): FavoritesEntity =
    FavoritesEntity(
        actor = actor,
        director = director,
        image = image,
        link = link,
        pubDate = pubDate,
        subtitle = subtitle,
        title = title,
        userRating = userRating
    )