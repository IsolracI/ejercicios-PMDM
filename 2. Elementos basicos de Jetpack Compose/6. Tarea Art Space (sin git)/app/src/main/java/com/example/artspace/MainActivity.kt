package com.example.artspace

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.artspace.ui.theme.ArtSpaceTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            ArtSpaceTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    ArtSpaceApp(modifier = Modifier.padding(innerPadding))
                }
            }
        }
    }
}

@Composable
fun ArtSpaceApp(modifier: Modifier = Modifier) {
    var id by remember {mutableIntStateOf(1)}

    if (id < 1) {
        id = 7
    }
    if (id > 7) {
        id = 1
    }

    val imageId = when (id) {
        1 -> R.drawable.dice_1
        2 -> R.drawable.dice_2
        3 -> R.drawable.dice_3
        4 -> R.drawable.dice_4
        5 -> R.drawable.dice_5
        6 -> R.drawable.dice_6
        else -> R.drawable.dice_6
    }
    val imageName = when (id) {
        1 -> R.string.los_comedores_de_patatas
        2 -> R.string.campo_de_trigo_con_cipreses
        3 -> R.string.san_juan_bautista
        4 -> R.string.la_ultima_cena
        5 -> R.string.narciso
        6 -> R.string.david_con_la_cabeza_de_goliat
        else -> R.string.san_jeronimo_en_meditacion
    }
    val imageAuthor = when (id) {
        1 -> R.string.van_gogh
        2 -> R.string.van_gogh
        3 -> R.string.leonardo_da_vinci
        4 -> R.string.leonardo_da_vinci
        5 -> R.string.carvaggio
        6 -> R.string.carvaggio
        else -> R.string.carvaggio
    }

    Column(modifier = Modifier.fillMaxSize()) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier.fillMaxSize()
                               .weight(9f)
        ) {
            Image(
                painter = painterResource(imageId),
                contentDescription = null,
                modifier = Modifier.padding(10.dp)
                                   .background(Color.LightGray)
                                   .fillMaxSize()
                                   .weight(17f)
            )
            Text(
                text = stringResource(imageName),
                fontWeight = FontWeight.Bold,
                fontSize = 30.sp,
                textAlign = TextAlign.Center,
                modifier = Modifier.fillMaxSize()
                                   .weight(2f)
                )
            Text(
                text = stringResource(imageAuthor),
                fontStyle = FontStyle.Italic,
                fontSize = 25.sp,
                textAlign = TextAlign.Center,
                modifier = Modifier.fillMaxSize()
                               .weight(1f)
            )
        }
        Spacer(modifier = Modifier.height(10.dp))
        Row(horizontalArrangement = Arrangement.SpaceAround, modifier = Modifier.fillMaxSize().weight(1f)) {
            Button({id -= 1}) {
                Text("<-")
            }
            Button({id += 1}) {
                Text("->")
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun ArtSpaceAppPreview() {
    ArtSpaceTheme {
        ArtSpaceApp(modifier = Modifier.fillMaxSize())
    }
}