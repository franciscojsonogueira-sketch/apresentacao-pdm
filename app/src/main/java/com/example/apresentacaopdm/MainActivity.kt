package com.example.apresentacaopdm

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.apresentacaopdm.databinding.ActivityMainBinding
import com.example.apresentacaopdm.compose.DarkLightModeActivity

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding // declarar variavel com tipo ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding =
            ActivityMainBinding.inflate(layoutInflater)// cria o objeto binding associado ao xml
        setContentView(binding.root) // Usa este layout como conteudo da pagina

        binding.buttonXml.setOnClickListener {  //vai buscar o botaoXML que esta no activity_main.xml
            val intent = Intent(this, XmlFormActivity::class.java)
            startActivity(intent) // abre a xml activity
        }

        binding.buttonCompose.setOnClickListener {  //vai buscar o botaoXML que esta no activity_main.xml
            val intent = Intent(this, ComposeFormActivity::class.java)
            startActivity(intent) // abre a xml activity

            //ComposeFormActivity::class.java <- original
            //DarkLightModeActivity::class.java
        }
    }
}
