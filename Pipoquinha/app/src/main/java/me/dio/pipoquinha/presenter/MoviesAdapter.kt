package me.dio.pipoquinha.presenter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import coil.load
import kotlinx.android.synthetic.main.movie_item_layout.view.*
import me.dio.pipoquinha.R
import me.dio.pipoquinha.domain.Movie

class MoviesAdapter(
    private val moviesList: List<Movie>,
    private val listener: OnItemClickListener
): RecyclerView.Adapter<MoviesAdapter.MoviesViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MoviesViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.movie_item_layout, parent, false)
        return MoviesViewHolder(view)
    }

    override fun onBindViewHolder(holder: MoviesViewHolder, position: Int) {

        holder.itemView.apply {
            movieTitle.text = moviesList[position].title
            movieImage.load(moviesList[position].image){

                placeholder(R.drawable.ic_image)

                fallback(R.drawable.ic_image)
            }
        }

    }


    override fun getItemCount(): Int = moviesList.size

    inner class MoviesViewHolder(

        itemView: View

    ) : RecyclerView.ViewHolder(itemView),
        View.OnClickListener{

        init {
            itemView.setOnClickListener(this)
        }

        override fun onClick(v: View?) {
            val position = adapterPosition
            if (position != RecyclerView.NO_POSITION) {
                listener.onItemClick(position)
            }
        }
    }
    interface OnItemClickListener {
        fun onItemClick(position: Int)
    }
}

