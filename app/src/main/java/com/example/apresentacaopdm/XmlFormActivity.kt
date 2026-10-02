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

        binding.buttonVoltar.setOnClickListener {
            finish()
        }
        // ========================================
// PESSOA 1 - IMPLEMENTAR FORMULÁRIO XML
// ========================================
    }
}