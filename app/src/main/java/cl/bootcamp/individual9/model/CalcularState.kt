package cl.bootcamp.individual9.model

data class CalcularState(
    val weight: String = "",
    val height: String = "",
    val imcResult: Double? = null,
    val selectedOption: String = "Hombre",
    val modal: Boolean = false
)
