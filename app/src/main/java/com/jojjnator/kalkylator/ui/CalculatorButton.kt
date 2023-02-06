package com.jojjnator.kalkylator.ui

import androidx.compose.animation.core.*
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.jojjnator.kalkylator.RandomGenerator
import com.jojjnator.kalkylator.ui.theme.BackgroundColor
import com.jojjnator.kalkylator.ui.theme.ButtonColor
import kotlin.math.roundToInt

@Composable
fun CalculatorNumberButton(
    modifier: Modifier = Modifier,
) {

    val randomColor = RandomGenerator.getRandomColor()
    val infiniteTransition = rememberInfiniteTransition()
    val noChillText by infiniteTransition.animateFloat(
        initialValue = 0f,
        targetValue = 9f,
        animationSpec = infiniteRepeatable(
            tween(100),
            repeatMode = RepeatMode.Restart
        )
    )

    Box(
        modifier = Modifier
            .background(randomColor)
            .border(border = BorderStroke(2.5.dp, color = BackgroundColor))
            .then(modifier),
        contentAlignment = Alignment.Center,

        ) {
        Text(
            text = noChillText.roundToInt().toString(),
            fontWeight = FontWeight.Light,
            style = TextStyle(fontSize = 25.sp)
        )
    }
}

@Composable
fun CalculatorOperatorButton(
    modifier: Modifier = Modifier,
    operator: String = ""
) {
    Box(
        modifier = Modifier
            .background(ButtonColor)
            .border(border = BorderStroke(2.5.dp, color = BackgroundColor))
            .then(modifier),
        contentAlignment = Alignment.Center,

        ) {
        Text(
            text = operator,
            fontWeight = FontWeight.Light,
            style = TextStyle(fontSize = 25.sp)
        )
    }
}