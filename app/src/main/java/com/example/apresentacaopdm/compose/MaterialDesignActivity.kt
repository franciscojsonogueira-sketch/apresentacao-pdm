
package com.example.apresentacaopdm.compose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.height
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.tooling.preview.Preview

class MaterialDesignActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            // Tema do Material Design 3.

            //"O Material Design 3 não serve apenas para fornecer componentes.
            // Também permite definir um tema visual, incluindo cores e tipografia, que
            // pode ser aplicado aos componentes da aplicação."


            MaterialTheme {

                Column(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(12.dp),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {

                    FormularioMaterial()

                    Spacer(modifier = Modifier.height(32.dp))

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

@Composable
fun FormularioMaterial() {

    val nome = remember { mutableStateOf("") }
    val email = remember { mutableStateOf("") }
    val idade = remember { mutableStateOf("") }

    Column(
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        Spacer(modifier = Modifier.height(24.dp))

        Text(
            text = "Formulário",
            fontSize = 28.sp,
            fontWeight = FontWeight.Bold,
            //O Material 3 já fornece uma escala de tipografia
                    // style = MaterialTheme.typography.headlineMedium
        )

        Spacer(modifier = Modifier.height(32.dp))

        //componente do Material Design 3 para introduzir texto
        TextField(
            value = nome.value,
            onValueChange = {
                nome.value = it
            },
            label = {
                Text("Nome")
            }
        )

        Spacer(modifier = Modifier.height(24.dp))

        //componente do Material Design 3 para introduzir texto
        TextField(
            value = email.value,
            onValueChange = {
                email.value = it
            },
            label = {
                Text("Email")
            }
        )

        Spacer(modifier = Modifier.height(24.dp))

        //componente do Material Design 3 para introduzir texto
        TextField(
            value = idade.value,
            onValueChange = {
                idade.value = it
            },
            label = {
                Text("Idade")
            }
        )

        Spacer(modifier = Modifier.height(24.dp))

        Button(
            onClick = {

            }
        ) {
            Text("Submeter")
        }
    }
}

@Preview(
    showBackground = true,
    widthDp = 360,
    heightDp = 800
)
@Composable
fun PreviewFormularioMaterial() {
    MaterialTheme {
        FormularioMaterial()
    }
}

