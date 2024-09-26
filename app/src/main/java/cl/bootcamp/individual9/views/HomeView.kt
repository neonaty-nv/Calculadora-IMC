package cl.bootcamp.individual9.views

import android.annotation.SuppressLint
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import cl.bootcamp.individual9.components.Avatar
import cl.bootcamp.individual9.components.CalculateButton
import cl.bootcamp.individual9.components.MainOutlinedText
import cl.bootcamp.individual9.components.MultiButtonSegmented
import cl.bootcamp.individual9.components.Result
import cl.bootcamp.individual9.components.Space
import cl.bootcamp.individual9.components.Texto
import cl.bootcamp.individual9.viewModels.CalcularViewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeView(modifier: Modifier, viewModel: CalcularViewModel) {
    Scaffold {
        ContentHomeView(it, viewModel)
    }
}

@Composable
fun ContentHomeView(paddingValues: PaddingValues, viewModel: CalcularViewModel){

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFFF7F9FC))
            .padding(paddingValues)
            .padding(30.dp),
        horizontalAlignment = Alignment.CenterHorizontally

    ) {

        val state = viewModel.state

        Texto("Calculadora de IMC")

        Space()

        Avatar(selectedOption = state.selectedOption)

        Space()

        MultiButtonSegmented(
            selectedOption = state.selectedOption,
            onOptionSelected = { option ->
                viewModel.onOptionSelected(option)
            }
        )

        Space()

        MainOutlinedText(
            value = state.weight,
            onValueChange = { viewModel.onValue(it, "weight")},
            label = "Peso"
        )
        MainOutlinedText(
            value = state.height,
            onValueChange = { viewModel.onValue(it, "height")},
            label = "Altura"
        )

        Space()

        CalculateButton(
            onClick = {
                if (state.weight.isNotEmpty() && state.height.isNotEmpty()) {
                    viewModel.calculateIMC()
                }
            },
            buttonText = "Calcular"
        )

        Space()

        Result(state.imcResult?.let { String.format("%.1f", it) } ?: "N/A")


    }
}


