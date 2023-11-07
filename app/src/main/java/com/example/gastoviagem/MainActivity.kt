package com.example.gastoviagem

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.gastoviagem.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity(), View.OnClickListener {

    private lateinit var binding: ActivityMainBinding

    /*
    * Função responsável por fazer a criação da Activity
    */
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.buttonCalculate.setOnClickListener(this)
    }

    /*
    *  Função responsável pelo clique do button certo.
    */
    override fun onClick(view: View) {
        if (view.id == R.id.button_calculate) {
            buttonCalculate()
        }
    }

    /*
    *  Função responsável por validar os campos de entrada do App.
    */
    private fun isValid(): Boolean {
        return (binding.editDistance.text.toString() != "" &&
                binding.editPrice.text.toString()    != "" &&
                binding.editAutonomy.text.toString() != "" &&
                binding.editAutonomy.text.toString().toFloat() != 0f )
    }

    /*
    *  Função responsável pela lógica que vai acontecer com o button, quando acionado.
    */
    private fun buttonCalculate() {
        if (isValid()) {
            val distance = binding.editDistance.text.toString().toFloat()
            val price = binding.editPrice.text.toString().toFloat()
            val autonomy = binding.editAutonomy.text.toString().toFloat()
            val totalValue = (distance * price) / autonomy
            binding.textTotalValue.text = "R$ ${"%.2f".format(totalValue)}"
        }
        else {
            Toast.makeText(this, R.string.validate_all_fields, Toast.LENGTH_SHORT).show()
        }
    }
}
