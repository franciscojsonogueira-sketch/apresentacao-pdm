package com.example.apresentacaopdm

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.apresentacaopdm.databinding.ActivityXmlFormBinding

class XmlFormActivity : AppCompatActivity() {

    private lateinit var binding: ActivityXmlFormBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityXmlFormBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnSubmit.setOnClickListener {
            val name = binding.etName.text.toString()
            if (name.isNotBlank()) {
                binding.tvResult.text = "Olá, $name! Formulário submetido com sucesso."
            } else {
                binding.tvResult.text = "Por favor, insere o teu nome."
            }
        }
    }
}