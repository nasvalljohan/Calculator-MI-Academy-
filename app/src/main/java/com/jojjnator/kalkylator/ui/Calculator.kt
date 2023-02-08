package com.jojjnator.kalkylator.ui

import androidx.compose.animation.core.*
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.jojjnator.kalkylator.interfaces.CalculatorAction
import com.jojjnator.kalkylator.ui.theme.BackgroundColor
import com.jojjnator.kalkylator.ui.theme.ButtonColor
import com.jojjnator.kalkylator.viewmodel.CalculatorViewModel
import com.jojjnator.kalkylator.viewmodel.GoTViewModel
import com.jojjnator.kalkylator.viewmodel.Operators
import org.koin.androidx.compose.koinViewModel

@Preview
@Composable
fun Calculator(viewModel: CalculatorViewModel = koinViewModel(), goTViewModel: GoTViewModel = koinViewModel()) {

    val fillMaxWidthModifier: Modifier = Modifier.fillMaxWidth()
    val modifierSmallBox: Modifier = Modifier.size(height = 70.dp, width = 90.dp)
    val modifierMediumBox: Modifier = Modifier.size(height = 70.dp, width = 180.dp)
    val modifierBigBox: Modifier = Modifier.size(height = 70.dp, width = 270.dp)

    val sumOfInput by animateIntAsState(
        targetValue = viewModel.calculatedSum.value.toInt(),
        tween(
            durationMillis = 1000
        )
    )

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(color = BackgroundColor)
            .padding(20.dp),
        verticalArrangement = Arrangement.Bottom,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Column(modifier = Modifier
            .padding(bottom = 10.dp),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                text = "The Crapculator",
                fontWeight = FontWeight.Bold,
                fontSize = 30.sp,
                color = Color.White,
            )
            Text(
                text = goTViewModel.response.value,
                fontWeight = FontWeight.Thin,
                fontSize = 16.sp,
                color = Color.White
            )
        }
        Box(
            modifier = Modifier
                .background(color = ButtonColor)
                .size(height = 200.dp, width = 355.dp)
        )
        {
            Column {
                Text(
                    text = sumOfInput.toString(),
                    fontWeight = FontWeight.Light,
                    fontSize = 30.sp,
                    modifier = Modifier.padding(10.dp)
                )

                Row {
                    Text(
                        text = viewModel.firstInput.value,
                        fontSize = 25.sp,
                        modifier = Modifier.padding(10.dp)
                    )
                    Text(
                        text = viewModel.operator.value,
                        fontSize = 25.sp,
                        modifier = Modifier.padding(10.dp)
                    )
                    Text(
                        text = viewModel.secondInput.value,
                        fontSize = 25.sp,
                        modifier = Modifier.padding(10.dp)
                    )

                }

            }

        }
        Row(
            modifier = fillMaxWidthModifier,
            horizontalArrangement = Arrangement.Center
        ) {
            CalculatorOperatorButton(
                modifier = modifierBigBox
                    .clickable { viewModel.checkInput(CalculatorAction.Clear) },
                operator = "CLEAR",
            )
            CalculatorOperatorButton(
                modifier = modifierSmallBox
                    .clickable { viewModel.checkInput(CalculatorAction.SetOperator(Operators.DIVIDE)) },
                operator = "/"
            )
        }
        Row(
            modifier = fillMaxWidthModifier,
            horizontalArrangement = Arrangement.Center
        ) {
            CalculatorNumberButton(
                modifier = modifierSmallBox
                    .clickable { viewModel.checkInput(CalculatorAction.SetNumber(viewModel.numbers[0])) },
                "?"
            )
            CalculatorNumberButton(
                modifier = modifierSmallBox
                    .clickable { viewModel.checkInput(CalculatorAction.SetNumber(viewModel.numbers[1])) },
                "?"
            )
            CalculatorNumberButton(
                modifier = modifierSmallBox
                    .clickable { viewModel.checkInput(CalculatorAction.SetNumber(viewModel.numbers[2])) },
                "?"
            )
            CalculatorOperatorButton(
                modifier = modifierSmallBox
                    .clickable { viewModel.checkInput(CalculatorAction.SetOperator(Operators.MULTIPLY)) },
                operator = "*"
            )
        }
        Row(
            modifier = fillMaxWidthModifier,
            horizontalArrangement = Arrangement.Center
        ) {
            CalculatorNumberButton(
                modifier = modifierSmallBox
                    .clickable { viewModel.checkInput(CalculatorAction.SetNumber(viewModel.numbers[3])) },
                "?"
            )
            CalculatorNumberButton(
                modifier = modifierSmallBox
                    .clickable { viewModel.checkInput(CalculatorAction.SetNumber(viewModel.numbers[4])) },
                "?"
            )
            CalculatorNumberButton(
                modifier = modifierSmallBox
                    .clickable { viewModel.checkInput(CalculatorAction.SetNumber(viewModel.numbers[5])) },
                "?"
            )
            CalculatorOperatorButton(
                modifier = modifierSmallBox
                    .clickable { viewModel.checkInput(CalculatorAction.SetOperator(Operators.MINUS)) },
                operator = "-"
            )
        }
        Row(
            modifier = fillMaxWidthModifier,
            horizontalArrangement = Arrangement.Center
        ) {
            CalculatorNumberButton(
                modifier = modifierSmallBox
                    .clickable { viewModel.checkInput(CalculatorAction.SetNumber(viewModel.numbers[6])) },
                "?"
            )
            CalculatorNumberButton(
                modifier = modifierSmallBox
                    .clickable { viewModel.checkInput(CalculatorAction.SetNumber(viewModel.numbers[7])) },
                "?"
            )
            CalculatorNumberButton(
                modifier = modifierSmallBox
                    .clickable { viewModel.checkInput(CalculatorAction.SetNumber(viewModel.numbers[8])) },
                "?"
            )
            CalculatorOperatorButton(
                modifier = modifierSmallBox
                    .clickable { viewModel.checkInput(CalculatorAction.SetOperator(Operators.PLUS)) },
                operator = "+"
            )
        }
        Row(
            modifier = fillMaxWidthModifier,
            horizontalArrangement = Arrangement.Center
        ) {
            CalculatorNumberButton(
                modifier = modifierMediumBox
                    .clickable { viewModel.checkInput(CalculatorAction.SetNumber(viewModel.numbers[9])) },
                "?"
            )
            CalculatorOperatorButton(
                modifier = modifierSmallBox
                    .clickable { viewModel.checkInput(CalculatorAction.Comma) },
                operator = "."
            )
            CalculatorOperatorButton(
                modifier = modifierSmallBox
                    .clickable { viewModel.checkInput(CalculatorAction.DoCalculation)
                               goTViewModel.getData()},
                operator = "="
            )
        }
    }

}