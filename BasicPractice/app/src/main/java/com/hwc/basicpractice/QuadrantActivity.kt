package com.hwc.basicpractice

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.hwc.basicpractice.ui.theme.BasicPracticeTheme

class QuadrantActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            BasicPracticeTheme {
                // A surface container using the 'background' color from the theme
                Surface(modifier = Modifier.fillMaxSize(), color = MaterialTheme.colors.background) {

                }
            }
        }
    }
}

@Composable
private fun LayoutView() {
    Column {
        Row(
            modifier = Modifier.weight(1.0F)
        ) {
            test()

            Column(
                modifier = Modifier
                    .weight(1.0F)
                    .fillMaxHeight()
                    .background(color = Color.Yellow)
                    .padding(16.dp)
            ) {
                ImageArea()
            }
        }

        Row(
            modifier = Modifier.weight(1.0F)
        ) {

        }
    }
}

@Composable
fun RowScope.test() {
    Column(
        modifier = Modifier
            .weight(1.0F)
            .fillMaxHeight()
            .background(color = Color.Green)
            .padding(16.dp),
        verticalArrangement = Arrangement.Center
    ) {
        Text(
            text = "Text composable",
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 16.dp),
            textAlign = TextAlign.Center,
            fontWeight = FontWeight.Bold
        )
        Text(
            text = "Displays text and follows Material Design guidelines.",
            modifier = Modifier.fillMaxWidth(),
            textAlign = TextAlign.Justify
        )
    }
}

@Composable
private fun ImageArea() {
    Text(text = "Image composable")
    Text(text = "Creates a composable that lays out and draws a given Painter class object.")
}

@Composable
private fun RowArea() {
    Text(text = "Row composable")
    Text(text = "A layout composable that places its children in a horizontal sequence.")
}

@Composable
private fun ColumnArea() {
    Text(text = "Column composable")
    Text(text = "A layout composable that places its children in a vertical sequence.")
}

@Preview(showBackground = true)
@Composable
private fun DefaultPreview() {
    BasicPracticeTheme {
        LayoutView()
    }
}
