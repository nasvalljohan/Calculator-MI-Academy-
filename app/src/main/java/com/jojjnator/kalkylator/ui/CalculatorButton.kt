package com.jojjnator.kalkylator.ui

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.jojjnator.kalkylator.ui.theme.BackgroundColor
import com.jojjnator.kalkylator.ui.theme.ButtonColor

@Composable
fun CalculatorButton(
    modifier: Modifier = Modifier,
    operator: String = "7",
    //onClick: (String) -> Unit
){
    Box(
        modifier = Modifier
            .background(ButtonColor)
            .border(border = BorderStroke(2.5.dp, color = BackgroundColor))
            .then(modifier),
        contentAlignment = Alignment.Center,

        ){
        Text(
            text = operator,
            fontWeight = FontWeight.Light,
            style = TextStyle(fontSize = 25.sp)
        )
    }
}