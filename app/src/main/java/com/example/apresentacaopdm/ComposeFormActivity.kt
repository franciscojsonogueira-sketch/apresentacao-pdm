package com.example.apresentacaopdm

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material3.Button
import androidx.compose.material3.Text

class ComposeFormActivity: ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {

            Button(
                onClick = {
                    finish()
                }
            ) {
                Text("Voltar")
            }

            // ========================================
// PESSOA 2 - IMPLEMENTAR FORMULÁRIO COMPOSE
// ========================================

        }
    }
}