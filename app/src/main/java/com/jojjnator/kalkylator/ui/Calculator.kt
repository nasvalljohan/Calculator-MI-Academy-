package com.jojjnator.kalkylator.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.jojjnator.kalkylator.ui.theme.BackgroundColor
import com.jojjnator.kalkylator.ui.theme.ButtonColor
import com.jojjnator.kalkylator.viewmodel.CalculatorViewModel

@Preview
@Composable
fun Calculator() {


    val viewModel = viewModel {CalculatorViewModel()}

    val fillMaxWidthModifier: Modifier = Modifier.fillMaxWidth()
    val modifierSmallBox: Modifier = Modifier.size(height = 70.dp, width = 90.dp)
    val modifierMediumBox: Modifier = Modifier.size(height = 70.dp, width = 180.dp)
    val modifierBigBox: Modifier = Modifier.size(height = 70.dp, width = 270.dp)

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(color = BackgroundColor)
            .padding(20.dp),
        verticalArrangement = Arrangement.Bottom,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Box(
            modifier = Modifier
                .background(color = ButtonColor)
                .size(height = 240.dp, width = 355.dp)

        )
        {
            Text(
                text = "500 + 500",
                fontWeight = FontWeight.Light,
                fontSize = 25.sp,
                modifier = Modifier.padding(10.dp)
            )
        }
        Row(
            modifier = fillMaxWidthModifier,
            horizontalArrangement = Arrangement.Center
        ) {
            CalculatorButton(
                modifier = modifierBigBox
                    .clickable { },
                operator = "CLEAR",
            )
            CalculatorButton(
                modifier = modifierSmallBox
                    .clickable { },
                operator = "/"
            )
        }
        Row(
            modifier = fillMaxWidthModifier,
            horizontalArrangement = Arrangement.Center
        ) {
            CalculatorButton(
                modifier = modifierSmallBox
                    .clickable { },
                operator = "7"
            )
            CalculatorButton(
                modifier = modifierSmallBox
                    .clickable { },
                operator = "8"
            )
            CalculatorButton(
                modifier = modifierSmallBox
                    .clickable { },
                operator = "9"
            )
            CalculatorButton(
                modifier = modifierSmallBox
                    .clickable { },
                operator = "*"
            )
        }
        Row(
            modifier = fillMaxWidthModifier,
            horizontalArrangement = Arrangement.Center
        ) {
            CalculatorButton(
                modifier = modifierSmallBox
                    .clickable { },
                operator = "4"
            )
            CalculatorButton(
                modifier = modifierSmallBox
                    .clickable { },
                operator = "5"
            )
            CalculatorButton(
                modifier = modifierSmallBox
                    .clickable { },
                operator = "6"
            )
            CalculatorButton(
                modifier = modifierSmallBox
                    .clickable { },
                operator = "-"
            )
        }
        Row(
            modifier = fillMaxWidthModifier,
            horizontalArrangement = Arrangement.Center
        ) {
            CalculatorButton(
                modifier = modifierSmallBox
                    .clickable { },
                operator = "1"
            )
            CalculatorButton(
                modifier = modifierSmallBox
                    .clickable { },
                operator = "2"
            )
            CalculatorButton(
                modifier = modifierSmallBox
                    .clickable { },
                operator = "3"
            )
            CalculatorButton(
                modifier = modifierSmallBox
                    .clickable { },
                operator = "+"
            )
        }
        Row(
            modifier = fillMaxWidthModifier,
            horizontalArrangement = Arrangement.Center
        ) {
            CalculatorButton(
                modifier = modifierMediumBox
                    .clickable { },
                operator = "0"
            )
            CalculatorButton(
                modifier = modifierSmallBox
                    .clickable { },
                operator = "."
            )
            CalculatorButton(
                modifier = modifierSmallBox
                    .clickable { },
                operator = "="
            )
        }
    }

}