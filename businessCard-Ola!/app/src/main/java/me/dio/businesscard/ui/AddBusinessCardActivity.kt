package me.dio.businesscard.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.activity.viewModels
import me.dio.businesscard.App
import me.dio.businesscard.data.BusinessCard
import me.dio.businesscard.databinding.ActivityAddBusinessCardBinding


class AddBusinessCardActivity : AppCompatActivity() {

    private val binding by lazy { ActivityAddBusinessCardBinding.inflate(layoutInflater)}

    private val mainViewModel: MainViewModel by viewModels {
        MainViewModelFactory((application as App).repository)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        insertListeners()
    }

    private fun insertListeners() {
        binding.btClose.setOnClickListener {
            finish()
        }
        binding.btConfirm.setOnClickListener {
            val businessCard = BusinessCard (
                name = binding.tilName.editText?.text.toString(),
                company = binding.tilCompany.editText?.text.toString(),
                phone = binding.tilPhone.editText?.text.toString(),
                email = binding.tilEmail.editText?.text.toString(),
                custombackground = binding.tilColor.editText?.text.toString()
            )
            mainViewModel.insert(businessCard)
            Toast.makeText(this, "Cartão cadastrado com sucesso", Toast.LENGTH_SHORT).show()
            finish()
        }
    }
}