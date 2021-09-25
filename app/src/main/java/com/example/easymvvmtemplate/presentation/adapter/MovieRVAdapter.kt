package com.example.easymvvmtemplate.presentation.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.easymvvmtemplate.data.remote.movie.dto.MovieItem
import com.example.easymvvmtemplate.databinding.ViewholderMovieItemBinding
import com.example.easymvvmtemplate.domain.model.Movie
import com.example.easymvvmtemplate.presentation.ui.main.search.SearchViewModel

class MovieRVAdapter(
    val viewModel : SearchViewModel?
) : RecyclerView.Adapter<MovieRVAdapter.ViewHolder>() {
    private var movieList: List<Movie> = listOf()

    inner class ViewHolder(
        private val binding: ViewholderMovieItemBinding
    ) : RecyclerView.ViewHolder(binding.root) {

        fun bindData(data: Movie) = with(binding) {

            data.title = data.title?.replace(Regex("</b>|<b>"), "")
            data.subtitle = data.subtitle?.replace(Regex("</b>|<b>"), "")

            movie = data
            viewModel = this@MovieRVAdapter.viewModel
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

    fun setMovieList(movieList: List<Movie>) {
        this.movieList = movieList
        notifyDataSetChanged()
    }
}