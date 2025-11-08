package com.example.cuadricula

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.cuadricula.data.DataSource
import com.example.cuadricula.ui.theme.CuadriculaTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            CuadriculaTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    CuadriculaApp(DataSource.DataSource.loadTopics(), modifier = Modifier.padding(innerPadding))
                }
            }
        }
    }
}

@Composable
fun CuadriculaApp(topics: List<Topic>, modifier: Modifier = Modifier) {
    LazyVerticalGrid(
        columns = GridCells.Fixed(2),
        verticalArrangement = Arrangement.spacedBy(8.dp),
        horizontalArrangement = Arrangement.spacedBy(8.dp),
        modifier = Modifier.statusBarsPadding()
                           .padding(8.dp),
        content = {
            items(topics) {topic ->
                TopicCard(
                    topic,
                    modifier = Modifier
                )
            }
        }
    )
}

@Composable
fun TopicCard(topic: Topic, modifier: Modifier = Modifier) {
    Card(
        modifier = Modifier.height(68.dp)
                           .width(200.dp)
    ) {
        Row {
            Image(
                painter = painterResource(topic.topicImageID),
                contentDescription = stringResource(topic.topicNameID),
                modifier = modifier.height(68.dp)
                                   .width(68.dp)
            )
            Column(
                modifier = Modifier.padding(start = 16.dp,
                                            top = 16.dp,
                                            end = 16.dp)
            ) {
                Text(
                    text = stringResource(topic.topicNameID),
                    style = MaterialTheme.typography.bodyMedium,
                    modifier = Modifier.padding(bottom = 8.dp)
                )
                Row(verticalAlignment = Alignment.CenterVertically) {
                    Image(
                        painter = painterResource(R.drawable.ic_grain),
                        contentDescription = null
                    )
                    Text(
                        text = topic.amountOfCourses.toString(),
                        style = MaterialTheme.typography.labelMedium,
                        modifier = Modifier.padding(start = 8.dp)
                    )
                }
            }
        }
    }
}

var topic1 = Topic(R.string.photography, 321, R.drawable.photography)

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    CuadriculaTheme {
        TopicCard(topic1)
    }
}