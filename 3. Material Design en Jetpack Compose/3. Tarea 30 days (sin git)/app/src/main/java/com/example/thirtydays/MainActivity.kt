package com.example.thirtydays

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.annotation.StringRes
import androidx.compose.animation.animateContentSize
import androidx.compose.animation.core.Spring
import androidx.compose.animation.core.spring
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.ui.theme.ThirtyDaysTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            ThirtyDaysTheme {
                ThirtyDays(month)
            }
        }
    }
}

val dia1 = Activity(R.string.dia1, R.string.titulo_dia_1, R.drawable.limon_serrano, R.string.descripcion_dia_1)
val dia2 = Activity(R.string.dia2, R.string.titulo_dia_2, R.drawable.ensalada_de_fideos_navidena, R.string.descripcion_dia_2)
val dia3 =    Activity(R.string.dia3, R.string.titulo_dia_3, R.drawable.ensalada_de_betarraga, R.string.descripcion_dia_3)
val dia4 = Activity(R.string.dia4, R.string.titulo_dia_4, R.drawable.ensalada_coleslaw, R.string.descripcion_dia_4)



val month = listOf<Activity>(
    Activity(R.string.dia1, R.string.titulo_dia_1, R.drawable.limon_serrano, R.string.descripcion_dia_1),
    Activity(R.string.dia2, R.string.titulo_dia_2, R.drawable.ensalada_de_fideos_navidena, R.string.descripcion_dia_2),
    Activity(R.string.dia3, R.string.titulo_dia_3, R.drawable.ensalada_de_betarraga, R.string.descripcion_dia_3),
    Activity(R.string.dia4, R.string.titulo_dia_4, R.drawable.ensalada_coleslaw, R.string.descripcion_dia_4)
)


@Composable
fun ThirtyDays(month: List<Activity>) {
    LazyColumn(
        contentPadding = PaddingValues(8.dp),
        verticalArrangement = Arrangement.spacedBy(8.dp),
        modifier = Modifier.statusBarsPadding()
    ) {
        items(month) { day ->
            ActivityCard(day)
        }
    }
}


@Composable
fun ActivityCard(
    activity: Activity,
    modifier: Modifier = Modifier
) {
    var expanded by remember { mutableStateOf(false) }
    Card(modifier = Modifier.fillMaxWidth(),
         ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier.padding(8.dp)
                               .fillMaxWidth()
                               .animateContentSize(
                                   animationSpec = spring(
                                       dampingRatio = Spring.DampingRatioNoBouncy,
                                       stiffness = Spring.StiffnessMedium
                                   ))
        ) {
            Text(
                text = stringResource(activity.dayNumer),
                textAlign = TextAlign.Center,
                style = MaterialTheme.typography.headlineMedium,
                modifier = Modifier.padding(bottom = 4.dp)
            )
            Text(
                text = stringResource(activity.activityTitle),
                textAlign = TextAlign.Center,
                style = MaterialTheme.typography.titleMedium,
            )
            Image(
                painter = painterResource(activity.activityImage),
                contentDescription = null,
            )
            if (!expanded) {
                ActivityButton(
                    expanded,
                    onClick = {expanded = !expanded},
                )
            }
            else if (expanded) {
                ActivityDescription(activity.activityDescription)
                ActivityButton(
                    expanded,
                    onClick = {expanded = !expanded},
                )
            }
        }
    }
}

@Composable
fun ActivityDescription(
    @StringRes description: Int,
    modifier: Modifier = Modifier
) {
    Text(
        text = stringResource(description),
        style = MaterialTheme.typography.bodyMedium,
        modifier = Modifier.padding(4.dp)
    )
}
@Composable
fun ActivityButton(
    expanded: Boolean,
    onClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    Button(onClick = onClick) {
        if (!expanded) {
            Text(
                text = "Mostrar más"
            )
        }
        else {
            Text(
                text = "Mostrar menos"
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    ThirtyDays(month)
}