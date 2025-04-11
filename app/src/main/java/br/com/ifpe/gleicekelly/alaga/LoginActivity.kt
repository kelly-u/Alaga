package br.com.ifpe.gleicekelly.alaga

import android.R
import android.app.Activity
import android.content.Intent
import android.content.Intent.FLAG_ACTIVITY_NO_HISTORY
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
import androidx.compose.ui.Alignment.Companion.CenterHorizontally
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import br.com.ifpe.gleicekelly.alaga.ui.theme.AlagaTheme
import com.google.firebase.Firebase
import com.google.firebase.auth.auth

class LoginActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            AlagaTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    LoginPage(
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun LoginPage(modifier: Modifier = Modifier) {
    var email by rememberSaveable { mutableStateOf("") }
    var password by rememberSaveable { mutableStateOf("") }
    val activity = LocalContext.current as? Activity
    Column(
        modifier = modifier.padding(16.dp).fillMaxSize().background(colorResource(id = br.com.ifpe.gleicekelly.alaga.R.color.blue_bg)),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = CenterHorizontally,
    ) {
        Text(
            text = "LOGIN",
            fontSize = 24.sp,
            fontWeight = FontWeight.Bold
        )
        OutlinedTextField(
            value = email,
            label = { Text(text = "Digite seu e-mail") },
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
        Row(modifier = modifier) {
            Button(onClick = {
                Firebase.auth.signInWithEmailAndPassword(email, password)
                    .addOnCompleteListener(activity!!) { task ->
                        if (task.isSuccessful) {
                            activity.startActivity(
                                Intent(activity, MainActivity::class.java).setFlags(
                                    FLAG_ACTIVITY_SINGLE_TOP
                                )
                            )
                            Toast.makeText(activity, "Login OK!", Toast.LENGTH_LONG).show()
                        } else {
                            Toast.makeText(activity, "Login FALHOU!", Toast.LENGTH_LONG).show()
                        }
                    }
            }, enabled = email.isNotEmpty() && password.isNotEmpty(),
            ){
                Text("Login")
            }
            Button(onClick = {
                email = ""; password = "" },
                enabled = email.isNotEmpty() && password.isNotEmpty()
            ) {
                Text("Limpar")
            }
            Button(
                onClick = {
                    activity?.startActivity(
                        Intent(activity, RegisterActivity::class.java).setFlags(
                            Intent.FLAG_ACTIVITY_SINGLE_TOP or FLAG_ACTIVITY_NO_HISTORY
                        )
                    )
                }
            ) {
                Text("Cadastre-se")
            }
        }
    }
}