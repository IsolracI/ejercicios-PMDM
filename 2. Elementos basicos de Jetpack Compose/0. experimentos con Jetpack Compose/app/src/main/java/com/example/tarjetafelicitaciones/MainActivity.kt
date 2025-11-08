package com.example.tarjetafelicitaciones

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.tarjetafelicitaciones.ui.theme.TarjetaFelicitacionesTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            TarjetaFelicitacionesTheme {
                Scaffold( modifier = Modifier.fillMaxSize() ) { innerPadding ->
                    GreetingList(nombres, Modifier.padding(innerPadding))
                }
            }
            Counter(6596969)
        }
    }
}

var nombres = listOf<String>("Sam", "Richard", "Antonio")

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Box(
        modifier = Modifier.background(Color.Blue).padding(16.dp)
    ) {
        Text(
            text = "Hello $name!",
            modifier = modifier,
            color = Color.Red
        )
    }
}

@Composable
fun GreetingList(names: List<String>, modifier: Modifier = Modifier) {
    Column {
        names.forEach {name -> Greeting(name, modifier)}
    }
}

@Composable
fun Counter(count: Int) {
    Text(text = "Count: $count")
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    TarjetaFelicitacionesTheme {
        Greeting("Android")
    }
}