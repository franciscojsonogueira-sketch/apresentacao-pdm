package com.example.apresentacaopdm

import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.util.Patterns
import androidx.appcompat.app.AppCompatActivity
import com.example.apresentacaopdm.databinding.ActivityXmlFormBinding
import com.example.apresentacaopdm.databinding.ActivityXmlFormMaterialBinding

class XmlFormActivity : AppCompatActivity() {

    private lateinit var binding: ActivityXmlFormBinding
    //private lateinit var binding: ActivityXmlFormMaterialBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityXmlFormBinding.inflate(layoutInflater)
        //binding = ActivityXmlFormMaterialBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Limpa os avisos de erro assim que o utilizador digita
        setupAutoClearErrors()

        // Ação do Botão Submeter com Validações
        binding.btnSubmit.setOnClickListener {
            val name = binding.etName.text.toString().trim()
            val email = binding.etEmail.text.toString().trim()
            val ageText = binding.etAge.text.toString().trim()

            // Identifica qual RadioButton foi selecionado
            val profileType = if (binding.rbPersonal.isChecked) "Pessoal" else "Profissional"

            // Reset inicial das mensagens de erro
            binding.etName.error = null
            binding.etEmail.error = null
            binding.etAge.error = null

            // 1. Validação do Nome
            if (name.isBlank()) {
                binding.etName.error = "Insira o seu nome"
                binding.tvResult.text = "Por favor, preencha todos os campos."
                return@setOnClickListener
            }

            // 2. Validação do Email (formato válido com @ e domínio)
            if (email.isBlank() || !Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
                binding.etEmail.error = "Insira um e-mail válido (ex: email@exemplo.com)"
                binding.tvResult.text = "Endereço de e-mail inválido."
                return@setOnClickListener
            }

            // 3. Validação da Idade (números válidos entre 1 e 120)
            val age = ageText.toIntOrNull()
            if (age == null || age <= 0 || age > 120) {
                binding.etAge.error = "Insira uma idade válida"
                binding.tvResult.text = "A idade tem de ser um número válido."
                return@setOnClickListener
            }

            // Se passar em todas as validações:
            binding.tvResult.text = " Sucesso!\nNome: $name\nE-mail: $email\nIdade: $age anos\nPerfil: $profileType"
        }

        // Ação do Botão Voltar
        binding.btnBack.setOnClickListener {
            finish()
        }
    }

    private fun setupAutoClearErrors() {
        val watcher = object : TextWatcher {
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {}
            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                if (!s.isNullOrBlank()) {
                    binding.tvResult.text = ""
                }
            }
            override fun afterTextChanged(s: Editable?) {}
        }

        binding.etName.addTextChangedListener(watcher)
        binding.etEmail.addTextChangedListener(watcher)
        binding.etAge.addTextChangedListener(watcher)
    }
}