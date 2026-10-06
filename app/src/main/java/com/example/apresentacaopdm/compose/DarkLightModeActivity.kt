package com.example.apresentacaopdm.compose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.material3.Surface

class DarkLightModeActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {

            //criou-se variavel pra saber qual o modo atual
            var darkMode by remember {   //O remember faz com que o valor seja mantido enquanto o Compose recompõe a interface
                mutableStateOf(false)
                //guarda false se LightMode e true se DarkMode
            }

            //Escolhe o tema dependendo da variavel
            val colorScheme =
                if (darkMode) {
                    darkColorScheme()
                } else {
                    lightColorScheme()
                }

            //tema é aplicado diretamente com o MaterialTheme
            MaterialTheme(
                colorScheme = colorScheme
            ) {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    Column(
                        modifier = Modifier
                            .fillMaxSize()
                            .padding(24.dp),
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {

                        Spacer(modifier = Modifier.height(50.dp))

                        Text(
                            text = if (darkMode) {
                                "Dark Mode"
                            } else {
                                "Light Mode"
                            },
                            style = MaterialTheme.typography.headlineMedium
                        )

                        Spacer(modifier = Modifier.height(30.dp))

                        // butão que altera o modo
                        Button(
                            onClick = {
                                darkMode = !darkMode
                            }
                        ) {
                            Text(
                                text = if (darkMode) {
                                    "Mudar para Light Mode"
                                } else {
                                    "Mudar para Dark Mode"
                                }
                            )
                        }

                        Spacer(modifier = Modifier.height(30.dp))

                        Button(
                            onClick = {
                                finish()
                            }
                        ) {
                            Text("Voltar")
                        }
                    }
                }
            }
        }

    }
}


