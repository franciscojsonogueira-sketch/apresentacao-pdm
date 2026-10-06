package com.example.apresentacaopdm

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.ui.unit.dp
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.runtime.MutableState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue

class ComposeFormActivity: ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent { //indica que a activity vai usar compose para construir a UI

            Column (
                modifier = Modifier
                    .fillMaxSize()
                    .padding(12.dp),
                horizontalAlignment = Alignment.CenterHorizontally
            ){
                Spacer(modifier = Modifier.height(24.dp))

                Formulario()

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

@Composable
fun Formulario() {
    Column(
        modifier = Modifier.padding(24.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ){
        var nome by remember{ mutableStateOf("")}
        var email by remember {mutableStateOf("")}
        var idade by remember{mutableStateOf("")}
        var mensagem by remember {mutableStateOf("")}
        Text(
            text = "Formulário",
            fontSize = 28.sp,
            fontWeight = FontWeight.Bold

        )

        Spacer(modifier = Modifier.height(32.dp))

        TextField(
            value = nome,
            onValueChange = { novoTexto ->
                nome = novoTexto
            },
            label = {
                Text("Nome")
            }
        )
        Spacer(modifier = Modifier.height(24.dp))

        TextField(
            value = email,
            onValueChange = { novoTexto ->
                email = novoTexto
            },
            label = {
                Text("Email")
            }
        )

        Spacer(modifier = Modifier.height(24.dp))

        TextField(
            value = idade,
            onValueChange = { novoTexto ->
                idade = novoTexto
            },
            label = {
                Text("Idade")
            }
        )

        Spacer(modifier = Modifier.height(24.dp))

        Button(
            onClick = {

                if(nome.isBlank() || idade.isBlank() || email.isBlank()) {
                    mensagem = "Preencha todos os campos"

                } else if (!email.contains("@") && !email.contains(".")){
                    mensagem = "Email inválido"

                } else if (idade.toIntOrNull() == null){
                    mensagem = "A idade deve ser um número"

                } else if (idade.toInt() < 0 || idade.toInt() > 120) {
                    mensagem = "Introduza uma idade válida."

                } else {
                    mensagem = "Formulário submetido com sucesso!"

                    nome = ""
                    email = ""
                    idade = ""
                }
            }
        ) {
            Text("Submeter")
        }

        Spacer(modifier = Modifier.height(12.dp))

        Text(mensagem)

        Spacer(modifier = Modifier.height(32.dp))

        Button(
            onClick = {

            }
        ){
            Text("Clicado 0 vezes")
        }
    }
}