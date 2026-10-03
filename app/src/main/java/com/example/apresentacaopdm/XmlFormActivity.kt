package com.example.apresentacaopdm

import android.os.Bundle
import android.util.Patterns
import androidx.appcompat.app.AppCompatActivity
import com.example.apresentacaopdm.databinding.ActivityXmlFormBinding

class XmlFormActivity : AppCompatActivity() {

    private lateinit var binding: ActivityXmlFormBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityXmlFormBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Ação do Botão Submeter com Validações
        binding.btnSubmit.setOnClickListener {
            val name = binding.etName.text.toString().trim()
            val email = binding.etEmail.text.toString().trim()
            val ageText = binding.etAge.text.toString().trim()

            // Reset dos avisos nos campos
            binding.etName.error = null
            binding.etEmail.error = null
            binding.etAge.error = null

            // 1. Validação do Nome
            if (name.isBlank()) {
                binding.etName.error = "Insira o seu nome"
                binding.tvResult.text = "Por favor, preencha todos os campos."
                return@setOnClickListener
            }

            // 2. Validação do Email (tem de ter @ e formato válido)
            if (email.isBlank() || !Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
                binding.etEmail.error = "Insira um e-mail válido (ex: email@exemplo.com)"
                binding.tvResult.text = "Endereço de e-mail inválido."
                return@setOnClickListener
            }

            // 3. Validação da Idade (apenas números e valor razoável)
            val age = ageText.toIntOrNull()
            if (age == null || age <= 0 || age > 120) {
                binding.etAge.error = "Insira uma idade válida"
                binding.tvResult.text = "A idade tem de ser um número válido."
                return@setOnClickListener
            }

            // Se passar em todas as validações:
            binding.tvResult.text = "Sucesso!\nNome: $name\nE-mail: $email\nIdade: $age anos"
        }

        // Ação do Botão Voltar ao Menu
        binding.btnBack.setOnClickListener {
            finish() // Fecha a atividade atual e regressa à MainActivity no topo da pilha
        }
    }
}