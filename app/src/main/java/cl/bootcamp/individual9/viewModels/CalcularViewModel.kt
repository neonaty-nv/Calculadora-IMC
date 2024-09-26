package cl.bootcamp.individual9.viewModels

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import cl.bootcamp.individual9.model.CalcularState

class CalcularViewModel : ViewModel() {

    var state by mutableStateOf(CalcularState())
        private set

    fun onValue(value: String, field: String) {
        when (field) {
            "weight" -> state = state.copy(weight = value)
            "height" -> state = state.copy(height = value)
        }
    }

    fun onOptionSelected(option: String) {
        state = state.copy(selectedOption = option)
    }

    fun calculateIMC() {
        val weight = state.weight.toDoubleOrNull()
        val heightInM = state.height.toDoubleOrNull()

        if (weight != null && heightInM != null && heightInM > 0) {
            val heightInM = heightInM / 100
            val imc = weight / (heightInM * heightInM)
            state = state.copy(imcResult = imc)
        } else {
            state = state.copy(imcResult = null)
        }
    }
}



