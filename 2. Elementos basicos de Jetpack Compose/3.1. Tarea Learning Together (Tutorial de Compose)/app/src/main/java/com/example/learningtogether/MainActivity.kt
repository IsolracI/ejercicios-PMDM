package com.example.learningtogether

import android.media.Image
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.learningtogether.ui.theme.LearningTogetherTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            LearningTogetherTheme {
                Tutorial(
                    stringResource(R.string.learning_together_tutorial_title),
                    stringResource(R.string.learning_together_texto_introduccion),
                    stringResource(R.string.learning_together_tutorial)
                )
            }
        }
    }
}

@Composable
fun Tutorial(titulo: String, introduccion: String, explicacion: String, modifier: Modifier = Modifier) {
    val imagenTutorial = painterResource(R.drawable.bg_compose_background)

    Column(modifier) {
        Image(
            painter = imagenTutorial,
            contentDescription = null,
            contentScale = ContentScale.FillWidth
        )
        Text(       // titulo
            text = titulo,
            fontSize = 24.sp,
            modifier = Modifier.padding(16.dp)
        )
        Text(       // introduccion
            text = introduccion,
            textAlign = TextAlign.Justify,
            modifier = Modifier.padding(16.dp)
        )
        Text(       // tutotial o explicacion
            text = explicacion,
            textAlign = TextAlign.Justify,
            modifier = Modifier.padding(16.dp)
        )
    }


}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    LearningTogetherTheme {
        Tutorial(stringResource(R.string.learning_together_tutorial_title), stringResource(R.string.learning_together_texto_introduccion), stringResource(R.string.learning_together_tutorial))
    }
}