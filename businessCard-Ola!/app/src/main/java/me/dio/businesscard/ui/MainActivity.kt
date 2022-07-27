 package me.dio.businesscard.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import me.dio.businesscard.App
import me.dio.businesscard.databinding.ActivityMainBinding

 class MainActivity : AppCompatActivity() {

     private val binding by lazy {ActivityMainBinding.inflate(layoutInflater)}
     private val mainViewModel: MainViewModel by viewModels {
         MainViewModelFactory((application as App).repository)
     }

     private val adapter by lazy { BusinessCardAdapter() }

     override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        binding.rvCards.adapter = adapter
        getAllBusinessCard()
        insertListener()
    }

    private fun insertListener() {
        binding.fab.setOnClickListener {
            val intent = Intent(this@MainActivity, AddBusinessCardActivity::class.java)
            startActivity(intent)
        }
    }

    private fun getAllBusinessCard() {
        mainViewModel.getAll().observe(this) { businessCards ->
            adapter.submitList(businessCards)
        }
    }
}