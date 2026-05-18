package com.example.calculadorapropinas

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            CalculadoraPropinas()
        } 
    }
}

@Composable
fun CalculadoraPropinas() {

    var montoCuenta by remember { mutableStateOf("") }
    var porcentajePropina by remember { mutableStateOf("") }
    var resultado by remember { mutableStateOf("") }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(24.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {

        Text(
            text = "Calculadora de Propinas App",
            style = MaterialTheme.typography.headlineMedium
        )

        Spacer(modifier = Modifier.height(24.dp))

        TextField(
            value = montoCuenta,
            onValueChange = { montoCuenta = it },
            label = { Text("Monto de la cuenta") },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
            modifier = Modifier.fillMaxWidth()
        )

        Spacer(modifier = Modifier.height(16.dp))

        TextField(
            value = porcentajePropina,
            onValueChange = { porcentajePropina = it },
            label = { Text("Porcentaje de propina") },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
            modifier = Modifier.fillMaxWidth()
        )

        Spacer(modifier = Modifier.height(20.dp))

        Button(
            onClick = {
                val cuenta = montoCuenta.toDoubleOrNull() ?: 0.0
                val porcentaje = porcentajePropina.toDoubleOrNull() ?: 0.0

                val propina = cuenta * porcentaje / 100
                val total = cuenta + propina

                resultado = "Propina: $${"%.2f".format(propina)}\nTotal a pagar: $${"%.2f".format(total)}"
            },
            modifier = Modifier.fillMaxWidth()
        ) {
            Text("Calcular Propina")
        }

        Spacer(modifier = Modifier.height(24.dp))

        Text(
            text = resultado,
            style = MaterialTheme.typography.bodyLarge
        )
    }
}