package cl.bootcamp.individual9.views

import android.annotation.SuppressLint
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import cl.bootcamp.individual9.components.CalculateButton
import cl.bootcamp.individual9.components.MultiButtonSegmented
import cl.bootcamp.individual9.components.OutlinedText
import cl.bootcamp.individual9.components.Space
import cl.bootcamp.individual9.components.Texto

@Preview(showBackground = true)
@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun HomeView() {
    Scaffold {
        ContentHomeView()
    }
}


@Composable
fun ContentHomeView(){
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFFF7F9FC))
            .padding(30.dp),
        verticalArrangement =Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally

    ) {
        Texto("Calculadora de IMC")

        Space()

        MultiButtonSegmented()

        Space()

        OutlinedText(label = "Edad")
        OutlinedText(label = "Peso (kg)")
        OutlinedText(label = "Altura (cm)")

        Space()

        CalculateButton {

        }

    }
}

