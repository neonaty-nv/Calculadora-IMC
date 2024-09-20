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
import cl.bootcamp.individual9.components.Avatar
import cl.bootcamp.individual9.components.CalculateButton
import cl.bootcamp.individual9.components.MainOutlinedText
import cl.bootcamp.individual9.components.MultiButtonSegmented
import cl.bootcamp.individual9.components.Result
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

    var selectedOption by remember { mutableStateOf("Hombre") }
    var age by remember { mutableStateOf("") }
    var weight by remember { mutableStateOf("") }
    var height by remember { mutableStateOf("") }
    var imcResult by remember { mutableDoubleStateOf(0.0) }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFFF7F9FC))
            .padding(30.dp),
        horizontalAlignment = Alignment.CenterHorizontally

    ) {
        Texto("Calculadora de IMC")

        Space()

        Avatar(selectedOption)

        Space()

        MultiButtonSegmented(selectedOption = selectedOption,
            onOptionSelected = { option -> selectedOption = option
        })
        Space()

        MainOutlinedText(value = age, onValueChange = { age = it }, label = "Edad")
        MainOutlinedText(value = weight, onValueChange = { weight = it }, label = "Peso")
        MainOutlinedText(value = height, onValueChange = { height = it }, label = "Altura")

        Space()

        CalculateButton(
            onClick = {
                val weightValue = weight.toDoubleOrNull() ?: 0.0
                val heightValue = (height.toDoubleOrNull() ?: 0.0) / 100
                if (weightValue > 0 && heightValue > 0) {
                    imcResult = calculateIMC(weightValue, heightValue)
                }
            },
            buttonText = "Calcular" // Puedes cambiar este texto
        )

        Space()

        Result(imcResult)

    }
}

fun calculateIMC(weight: Double, height: Double): Double {
    return kotlin.math.round(weight / (height * height) * 10) / 10
}

