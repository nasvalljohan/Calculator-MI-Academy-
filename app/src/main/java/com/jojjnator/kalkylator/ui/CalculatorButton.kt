package com.jojjnator.kalkylator.ui

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.jojjnator.kalkylator.RandomGenerator
import com.jojjnator.kalkylator.ui.theme.BackgroundColor
import com.jojjnator.kalkylator.ui.theme.ButtonColor

@Composable
fun CalculatorNumberButton(
    modifier: Modifier = Modifier,
    digit: String
) {
    val randomColor = RandomGenerator.getRandomColor()

    Box(
        modifier = Modifier
            .background(randomColor)
            .border(border = BorderStroke(2.5.dp, color = BackgroundColor))
            .then(modifier),
        contentAlignment = Alignment.Center,

        ) {
        Text(
            text = digit,
            fontWeight = FontWeight.Light,
            style = TextStyle(fontSize = 25.sp)
        )
    }
}

@Composable
fun CalculatorOperatorButton(
    modifier: Modifier = Modifier,
    operator: String
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