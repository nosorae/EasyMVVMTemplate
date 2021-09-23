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

            /*
            The Data Binding Library is a support library
            that allows you to bind UI components in your layouts
            to data sources in your app
            using a declarative format rather than programmatically.

            This can also improve your app's performance
            and help prevent memory leaks and null pointer exceptions.
             */

            Glide.with(root)
                .load(data.image)
                .apply(RequestOptions().override(300, 450))
                .apply(RequestOptions.centerCropTransform())
                .into(moviePoster)

            movie = data
            viewModel = this@MovieAdapter.viewModel
            executePendingBindings() //뷰를 강제로 업데이트하며 notifyDataSetChanged()와 기능적으로 유사.
            //Evaluates the pending bindings, updating any Views that have expressions bound to modified variables. This must be run on the UI thread.
            /*
            RecyclerView will measure the row size after the onBindViewHolder has completed.
            If based on the data you set in this method the height of the row changes,
            the measurement could not take into account the extra or reduced space occupied
            by your new content if you do not call executePendingBindings().
             */


            //binding.movieTitle = data.title
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