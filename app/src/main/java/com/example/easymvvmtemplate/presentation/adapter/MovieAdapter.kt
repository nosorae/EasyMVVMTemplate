package com.example.easymvvmtemplate.presentation.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.easymvvmtemplate.data.entity.MovieEntity
import com.example.easymvvmtemplate.databinding.ViewholderMovieItemBinding

class MovieAdapter : RecyclerView.Adapter<MovieAdapter.ViewHolder>() {
    private var movieList: List<MovieEntity> = listOf()
    private lateinit var movieItemClickListener: (MovieEntity) -> Unit


    inner class ViewHolder(
        private val binding: ViewholderMovieItemBinding,
        val movieItemClickListener: (MovieEntity) -> Unit
    ) : RecyclerView.ViewHolder(binding.root) {
        fun bindData(data: MovieEntity) = with(binding) {
            Glide.with(root)
                .load(data.image)
                .into(moviePoster)


            movieTitle.text = data.title ?: "Unknown"
            movieSubtitle.text = data.subtitle ?: "Unknown"
            movieRatings.text = data.userRating ?: "Unknown"

        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder =
        ViewHolder(ViewholderMovieItemBinding.inflate(LayoutInflater.from(parent.context), parent, false), movieItemClickListener)

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bindData(movieList[position])
    }

    override fun getItemCount(): Int = movieList.size

    fun setMovieList(movieList: List<MovieEntity>, movieItemClickListener: (MovieEntity) -> Unit) {
        this.movieList = movieList
        this.movieItemClickListener = movieItemClickListener
        notifyDataSetChanged()
    }
}