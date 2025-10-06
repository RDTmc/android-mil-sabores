package com.milsabores.app

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.milsabores.app.ui.theme.MilSaboresTheme


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MilSaboresTheme {
                HomeScreen()
            }
        }
    }
}

@Preview
@Composable
fun HomeScreen() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(24.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Image(
            painter = painterResource(id = R.drawable.logo_pasteleria),
            contentDescription = "Logo Mil Sabores",
            modifier = Modifier.size(180.dp),
            contentScale = ContentScale.Fit
        )
        Spacer(modifier = Modifier.height(32.dp))
        Button(
            onClick = { /* Navegar a catálogo */ },
            modifier = Modifier.fillMaxWidth()
        ) {
            Text("Ver catálogo")
        }
    }
}
