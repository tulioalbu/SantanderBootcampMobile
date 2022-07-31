package br.com.dio.businesscard.ui

import android.os.Bundle
import android.widget.Toast
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import br.com.dio.businesscard.App
import br.com.dio.businesscard.R
import br.com.dio.businesscard.data.BusinessCard
import br.com.dio.businesscard.databinding.ActivityAddBusinessCardBinding
import yuku.ambilwarna.AmbilWarnaDialog


class AddBusinessCardActivity : AppCompatActivity() {

    private var mDefaultColor = R.color.primaryColor
    private val binding by lazy { ActivityAddBusinessCardBinding.inflate(layoutInflater) }

    private val mainViewModel: MainViewModel by viewModels {
        MainViewModelFactory((application as App).repository)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        insertListeners()
    }

    private fun setColorPicker() {
        val dialog = AmbilWarnaDialog(this@AddBusinessCardActivity, mDefaultColor,
            object : AmbilWarnaDialog.OnAmbilWarnaListener {
                override fun onOk(dialog: AmbilWarnaDialog, color: Int) {
                    binding.btColor.setBackgroundColor(color)
                    mDefaultColor = color
                }

                override fun onCancel(dialog: AmbilWarnaDialog) {
                    Toast.makeText(applicationContext, "cancel", Toast.LENGTH_SHORT).show()
                }
            })
        dialog.show()
    }

    private fun insertListeners() {


        binding.btColor.setOnClickListener { setColorPicker() }

        binding.btnConfirm.setOnClickListener {
            val businessCard = BusinessCard(
                nome = binding.tilNome.editText?.text.toString(),
                empresa = binding.tilEmpresa.editText?.text.toString(),
                telefone = binding.tilTelefone.editText?.text.toString(),
                email = binding.tilEmail.editText?.text.toString(),
                fundoPersonalizado = mDefaultColor.toString()
            )
            mainViewModel.insert(businessCard)
            Toast.makeText(this, R.string.label_show_success, Toast.LENGTH_SHORT).show()
            finish()
        }

        binding.btnClose.setOnClickListener {
            finish()
        }



    }

}


