package br.com.ifpe.gleicekelly.alaga

import android.app.Activity
import android.content.Intent
import android.content.Intent.FLAG_ACTIVITY_SINGLE_TOP
import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.google.firebase.Firebase
import com.google.firebase.auth.auth
import br.com.ifpe.gleicekelly.alaga.ui.db.fb.FBDatabase
import br.com.ifpe.gleicekelly.alaga.ui.model.User
import br.com.ifpe.gleicekelly.alaga.ui.theme.AlagaTheme

class RegisterActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            AlagaTheme {
                Scaffold( modifier = Modifier.fillMaxSize() ) { innerPadding ->
                    RegisterPage(
                        modifier = Modifier.padding(innerPadding),
                    )
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun RegisterPage(modifier: Modifier = Modifier) {
    var nomeUsuario by rememberSaveable { mutableStateOf("") }
    var email by rememberSaveable { mutableStateOf("") }
    var password by rememberSaveable { mutableStateOf("") }
    var confPassword by rememberSaveable { mutableStateOf("") }
    val activity = LocalContext.current as? Activity

    Column(
        modifier = modifier.padding(16.dp).fillMaxSize().background(colorResource(id = br.com.ifpe.gleicekelly.alaga.R.color.blue_bg)),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = "CADASTRO",
            fontSize = 24.sp,
            fontWeight = FontWeight.Bold,
        )
        OutlinedTextField(
            value = nomeUsuario,
            label = { Text(text = "Digite seu nome de usuário") },
            modifier = modifier.fillMaxWidth().background(colorResource(id = br.com.ifpe.gleicekelly.alaga.R.color.white)),
            onValueChange = { nomeUsuario = it }
        )
        OutlinedTextField(
            value = email,
            label = { Text(text = "Digite seu email") },
            modifier = modifier.fillMaxWidth().background(colorResource(id = br.com.ifpe.gleicekelly.alaga.R.color.white)),
            onValueChange = { email = it }
        )

        OutlinedTextField(
            value = password,
            label = { Text(text = "Digite sua senha") },
            modifier = modifier.fillMaxWidth().background(colorResource(id = br.com.ifpe.gleicekelly.alaga.R.color.white)),
            onValueChange = { password = it },
            visualTransformation = PasswordVisualTransformation()
        )

        OutlinedTextField(
            value = confPassword,
            label = { Text(text = "Digite sua senha novamente") },
            modifier = modifier.fillMaxWidth().background(colorResource(id = br.com.ifpe.gleicekelly.alaga.R.color.white)),
            onValueChange = { confPassword = it },
            visualTransformation = PasswordVisualTransformation()
        )

        Row(modifier = modifier) {
            Button(
                onClick = {
                    Firebase.auth.createUserWithEmailAndPassword(email, password)
                        .addOnCompleteListener(activity!!) { task ->
                            if (task.isSuccessful) {
                                Toast.makeText(activity,"Cadastro OK!", Toast.LENGTH_LONG).show()
                                activity.startActivity(
                                    Intent(activity, MainActivity::class.java).setFlags(
                                        FLAG_ACTIVITY_SINGLE_TOP )
                                )
                                FBDatabase().register(User(nomeUsuario, email))
                            } else {
                                Toast.makeText(activity,
                                    "Cadastro FALHOU!", Toast.LENGTH_LONG).show()
                            }
                        }
                },
                enabled = nomeUsuario.isNotEmpty() && email.isNotEmpty() && password.isNotEmpty() && confPassword.isNotEmpty() && password.equals(confPassword)
            ) {
                Text("Cadastrar")
            }
            Button(
                onClick = {
                    nomeUsuario = ""; email = ""; password = ""; confPassword = ""} ,
                enabled = nomeUsuario.isNotEmpty() && email.isNotEmpty() && password.isNotEmpty() && confPassword.isNotEmpty()
            ){
                Text("Limpar")
            }
        }
    }
}