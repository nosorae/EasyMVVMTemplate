package com.example.easymvvmtemplate.presentation.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.example.easymvvmtemplate.data.entity.MovieEntity
import com.example.easymvvmtemplate.databinding.ViewholderMovieItemBinding
import com.example.easymvvmtemplate.presentation.ui.main.search.SearchViewModel

class MovieAdapter(
    val viewModel : SearchViewModel?
) : RecyclerView.Adapter<MovieAdapter.ViewHolder>() {
    private var movieList: List<MovieEntity> = listOf()

    inner class ViewHolder(
        private val binding: ViewholderMovieItemBinding
    ) : RecyclerView.ViewHolder(binding.root) {

        fun bindData(data: MovieEntity) = with(binding) {

            Glide.with(root)
                .load(data.image)
                .apply(RequestOptions().override(300, 450))
                .apply(RequestOptions.centerCropTransform())
                .into(moviePoster)

            movie = data
            viewModel = this@MovieAdapter.viewModel
            executePendingBindings()
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder =
        ViewHolder(
            ViewholderMovieItemBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bindData(movieList[position])
    }

    override fun getItemCount(): Int = movieList.size

    fun setMovieList(movieList: List<MovieEntity>) {
        this.movieList = movieList
        notifyDataSetChanged()
    }
}