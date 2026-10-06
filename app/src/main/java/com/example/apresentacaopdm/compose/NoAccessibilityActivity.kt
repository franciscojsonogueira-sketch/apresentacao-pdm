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
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview

class AccessibilityActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {

            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(8.dp),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {

                Spacer(modifier = Modifier.height(10.dp))

                FormularioNaoAcessivel()

                Spacer(modifier = Modifier.height(15.dp))

                Button(
                    modifier = Modifier
                        .height(30.dp),
                    onClick = {
                        finish()
                    }
                ) {
                    Text(
                        text = "Voltar",
                        fontSize = 10.sp
                    )
                }
            }
        }
    }
}

@Composable
fun FormularioNaoAcessivel() {

    var nome by remember { mutableStateOf("") }
    var email by remember { mutableStateOf("") }
    var idade by remember { mutableStateOf("") }

    Column(
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        Text(
            text = "Formulário",
            fontSize = 14.sp,
            color = Color.Gray
        )

        Spacer(modifier = Modifier.height(15.dp))

        // Campo sem identificação clara
        TextField(
            value = nome,
            onValueChange = {
                nome = it
            }
        )

        Spacer(modifier = Modifier.height(10.dp))

        TextField(
            value = email,
            onValueChange = {
                email = it
            }
        )

        Spacer(modifier = Modifier.height(10.dp))

        TextField(
            value = idade,
            onValueChange = {
                idade = it
            }
        )

        Spacer(modifier = Modifier.height(10.dp))

        Button(
            modifier = Modifier.height(30.dp),
            onClick = {

            }
        ) {
            Text(
                text = "Submeter",
                fontSize = 10.sp
            )
        }
    }
}

@Preview(
    showBackground = true,
    widthDp = 360,
    heightDp = 600
)
@Composable
fun PreviewFormularioNaoAcessivel() {
    FormularioNaoAcessivel()
}