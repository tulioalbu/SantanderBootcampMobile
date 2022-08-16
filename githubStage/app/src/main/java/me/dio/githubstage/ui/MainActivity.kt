package me.dio.githubstage.ui

import android.os.Bundle
import android.util.Log
import android.view.Menu
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.SearchView
import me.dio.githubstage.R
import me.dio.githubstage.core.createDialog
import me.dio.githubstage.core.createProgressDialog
import me.dio.githubstage.core.hideSoftKeyboard
import me.dio.githubstage.databinding.ActivityMainBinding
import me.dio.githubstage.presentation.MainViewModel
import org.koin.androidx.viewmodel.ext.android.viewModel

class MainActivity : AppCompatActivity(), SearchView.OnQueryTextListener {


    private val viewModel by viewModel<MainViewModel>()
    private val adapter by lazy { RepoListAdapter()}
    private val dialog by lazy { createProgressDialog() }
    private val binding by lazy { ActivityMainBinding.inflate(layoutInflater) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        setSupportActionBar(binding.toolbar)
        setMessage(R.string.label_initial)
        binding.rvRepos.adapter = adapter

        viewModel.repos.observe(this) {
            when (it) {
                MainViewModel.State.Loading -> {
                    dialog.show()

                }
                is MainViewModel.State.Error -> {
                    createDialog {
                        setMessage(it.error.message)
                    }.show()
                    dialog.dismiss()
                }
                is MainViewModel.State.Success -> {
                    dialog.dismiss()
                    binding.tvMessages.visibility = View.INVISIBLE
                    adapter.submitList(it.list)
                }
            }
        }

    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.main_menu, menu)
        val searchView = menu.findItem(R.id.action_search).actionView as SearchView
        searchView.setOnQueryTextListener(this)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onQueryTextSubmit(query: String?): Boolean {
        query?.let {viewModel.getRepoList(it)}
        binding.root.hideSoftKeyboard()
        return true
    }

    override fun onQueryTextChange(newText: String?): Boolean {
        Log.e(TAG, "onQueryTextChange: $newText")
        return false
    }

    private fun setMessage(message: Int) {
        binding.tvMessages.setText(message)
        binding.tvMessages.visibility = View.VISIBLE
    }

    companion object {
        private const val TAG = "TAG"
    }
}