package me.dio.pipoquinha.presenter


import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.lifecycle.ViewModelProvider
import kotlinx.android.synthetic.main.activity_main.*
import me.dio.pipoquinha.R
import me.dio.pipoquinha.domain.Movie
import me.dio.pipoquinha.framework.api.viewmodel.MovieListViewModel

class MainActivity : AppCompatActivity(), MoviesAdapter.OnItemClickListener {

    private lateinit var movieListViewModel: MovieListViewModel
    private lateinit var moviesList: List<Movie>


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        movieListViewModel = ViewModelProvider.NewInstanceFactory().create(MovieListViewModel::class.java)
        movieListViewModel.init()
        initObserver()
        loadingVisibility(true)
    }
    private fun initObserver(){
        movieListViewModel.moviesList.observe(this) { list ->
            if (list.isNotEmpty()) {
                moviesList = list
                populateList(list)
                loadingVisibility(false)
            }
        }
    }



    private fun populateList(list: List<Movie>) {
        moviesListRV.hasFixedSize()
        moviesList = list
        moviesListRV.adapter = MoviesAdapter(list,this)

    }

    private fun loadingVisibility(isLoading: Boolean){
        progressBar.visibility = if (isLoading) View.VISIBLE else View.GONE

    }

    override fun onItemClick(position: Int) {
        val intent = Intent(this, MoviesDetailActivity::class.java)
        intent.putExtra("movie", moviesList[position]
        )
        startActivity(intent)
    }
}