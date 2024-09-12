package cl.bootcamp.individual9.components

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
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
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
import androidx.compose.ui.text.font.FontWeight
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

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun OutlinedText(label: String) {
    OutlinedTextField(
        value = "",
        onValueChange = {},
        label = { Text(label) },
        modifier = Modifier.fillMaxWidth()
    )
}

@Composable
fun Space(){
    Spacer(modifier = Modifier.height(30.dp))
}

@Composable
fun MultiButtonSegmented() {
    var selectedOption by remember { mutableStateOf("Hombre") }

    Row(
        modifier = Modifier
            .fillMaxWidth()
    ) {

        Button(
            onClick = { selectedOption = "Hombre" },
            modifier = Modifier
                .weight(1f),
            shape = RoundedCornerShape(4.dp),
            colors = if (selectedOption == "Hombre") {
                ButtonDefaults.buttonColors(containerColor = Color(0xFF16A3CE))
            } else {
                ButtonDefaults.buttonColors(containerColor = Color(0xFFE0E0E0))
            }
        ) {
            if (selectedOption == "Hombre") {
                Icon(
                    imageVector = Icons.Filled.Check,
                    contentDescription = "Selected",
                    tint = Color.White,
                    modifier = Modifier.padding(end = 4.dp)
                )
            }
            Text(
                text = "Hombre",
                color = if (selectedOption == "Hombre") Color.White else Color.Black
            )
        }

        Spacer(modifier = Modifier.width(10.dp))

        Button(
            onClick = { selectedOption = "Mujer" },
            modifier = Modifier
                .weight(1f),
            shape = RoundedCornerShape(4.dp),
            colors = if (selectedOption == "Mujer") {
                ButtonDefaults.buttonColors(containerColor = Color(0xFF16A3CE))
            } else {
                ButtonDefaults.buttonColors(containerColor = Color(0xFFE0E0E0))
            }
        ) {
            if (selectedOption == "Mujer") {
                Icon(
                    imageVector = Icons.Filled.Check,
                    contentDescription = "Selected",
                    tint = Color.White,
                    modifier = Modifier.padding(end = 4.dp)
                )
            }
            Text(
                text = "Mujer",
                color = if (selectedOption == "Mujer") Color.White else Color.Black
            )
        }
    }
}

//@Composable
//fun CalculateButton(onClick: () -> Unit) {
//    Button(
//        onClick = onClick,
//        modifier = Modifier.fillMaxWidth(),
//        shape = RoundedCornerShape(4.dp),
//        colors = ButtonDefaults.buttonColors(
//            containerColor = Color(0xFF0ED6B8)
//        )
//
//    ) {
//        Text("Calcular",
//            fontSize = 18.sp,
//            fontFamily = Montserrat)
//    }
//}

@Composable
fun CalculateButton(onClick: () -> Unit) {
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
            "Calcular",
            fontSize = 18.sp,
            fontFamily = Montserrat,
            color = Color.White
        )
    }
}
