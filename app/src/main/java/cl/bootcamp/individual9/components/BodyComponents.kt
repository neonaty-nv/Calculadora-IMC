package cl.bootcamp.individual9.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Check
import androidx.compose.material3.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import cl.bootcamp.individual9.R
import cl.bootcamp.individual9.ui.theme.Montserrat


@Composable
fun Texto(texto: String) {
    Text(
        text = texto,
        fontFamily = Montserrat,
        fontWeight = FontWeight.Bold,
        fontSize = 25.sp,
        textAlign = TextAlign.Center,
        modifier = Modifier
            .padding(horizontal = 30.dp)
            .fillMaxWidth()
    )
}

@Composable
fun Avatar(selectedOption: String) {
    val avatarImage = if (selectedOption == "Hombre") {
        R.drawable.man_avatar
    } else {
        R.drawable.woman_avatar
    }

    Image(
        painter = painterResource(id = avatarImage),
        contentDescription = null,
        modifier = Modifier.fillMaxWidth().height(150.dp)
    )
}


@Composable
fun MainOutlinedText(
    value: String,
    onValueChange: (String) -> Unit,
    label: String
){
    OutlinedTextField(
        value = value,
        onValueChange = onValueChange,
        label = { Text(text = label) },
        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
        modifier = Modifier
            .fillMaxWidth(),
        textStyle = TextStyle(
            fontSize = 20.sp,
            textAlign = TextAlign.Center
        )
    )
}


@Composable
fun Space(){
    Spacer(modifier = Modifier.height(30.dp))
}

@Composable
fun MultiButtonSegmented(selectedOption: String, onOptionSelected: (String) -> Unit) {
    Row(modifier = Modifier.fillMaxWidth()) {
        val options = listOf("Hombre", "Mujer")

        options.forEach { option ->
            Button(
                onClick = { onOptionSelected(option) },
                modifier = Modifier.weight(1f),
                shape = RoundedCornerShape(4.dp),
                colors = if (selectedOption == option) {
                    ButtonDefaults.buttonColors(containerColor = Color(0xFF16A3CE))
                } else {
                    ButtonDefaults.buttonColors(containerColor = Color(0xFFE0E0E0))
                }
            ) {
                if (selectedOption == option) {
                    Icon(
                        imageVector = Icons.Filled.Check,
                        contentDescription = "Selected",
                        tint = Color.White,
                        modifier = Modifier.padding(end = 4.dp)
                    )
                }
                Text(
                    text = option,
                    color = if (selectedOption == option) Color.White else Color.Black
                )
            }

            if (option != options.last()) {
                Spacer(modifier = Modifier.width(10.dp))
            }
        }
    }
}


@Composable
fun CalculateButton(onClick: () -> Unit, buttonText: String) {
    val gradientBrush = Brush.horizontalGradient(
        colors = listOf(Color(0xFF16A3CE), Color(0xFF0ED6B8))
    )

    Box(
        modifier = Modifier
            .fillMaxWidth()
            .clip(RoundedCornerShape(4.dp))
            .background(gradientBrush)
            .clickable(onClick = onClick)
            .padding(12.dp),
        contentAlignment = Alignment.Center
    ) {
        Text(
            text = buttonText,
            fontSize = 18.sp,
            fontFamily = Montserrat,
            color = Color.White
        )
    }
}

@Composable
fun Result(imc: String) {
    Text(
        text = "IMC: $imc",
        fontFamily = Montserrat,
        fontSize = 40.sp,
        textAlign = TextAlign.Center
    )
}

@Composable
fun Alert(
    title: String,
    message: String,
    confirmText: String,
    onConfirmClick: () -> Unit,
    onDismissClick: () -> Unit
) {
    AlertDialog(
        onDismissRequest = onDismissClick,
        title = { Text(
            text = title,
            fontFamily = Montserrat,
            fontWeight = FontWeight.Bold,
            ) },
        text = { Text(text = message, fontSize = 18.sp,
        ) },
        confirmButton = {
            Button(
                onClick = onConfirmClick,
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color(0xFF16A3CE))
        ) {
                Text(text = confirmText)
            }
        }


    )
}
