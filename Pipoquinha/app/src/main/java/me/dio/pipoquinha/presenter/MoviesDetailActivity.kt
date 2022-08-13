package me.dio.pipoquinha.presenter

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import coil.load
import kotlinx.android.synthetic.main.activity_movie_details.*
import me.dio.pipoquinha.R
import me.dio.pipoquinha.domain.Movie

class MoviesDetailActivity : AppCompatActivity() {
        override fun onCreate(savedInstanceState: Bundle?) {
            super.onCreate(savedInstanceState)
            setContentView(R.layout.activity_movie_details)

            val movie = intent.extras?.getParcelable<Movie>("movie")

            tv_movie_title.text = movie?.title
            tv_movie_overview.text = movie?.description

            iv_movie_poster.load(movie?.image) {
                placeholder(R.drawable.ic_image)
                fallback(R.drawable.ic_image)
            }
        }
    }
