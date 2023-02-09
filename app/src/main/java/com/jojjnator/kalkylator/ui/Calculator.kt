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
import com.jojjnator.kalkylator.viewmodel.QuoteViewModel
import com.jojjnator.kalkylator.viewmodel.Operators
import org.koin.androidx.compose.koinViewModel

@Preview
@Composable
fun Calculator(
    viewModel: CalculatorViewModel = koinViewModel(),
    quoteViewModel: QuoteViewModel = koinViewModel()
) {

    val fillMaxWidthModifier: Modifier = Modifier.fillMaxWidth()
    val modifierSmallBox: Modifier = Modifier.size(height = 70.dp, width = 90.dp)
    val modifierMediumBox: Modifier = Modifier.size(height = 70.dp, width = 180.dp)
    val modifierBigBox: Modifier = Modifier.size(height = 70.dp, width = 270.dp)

    val onClearClicked: () -> Unit = {
        viewModel.checkInput(CalculatorAction.Clear)
        quoteViewModel.newQuote()
    }
    val onEqualsClicked: () -> Unit = {
        viewModel.checkInput(CalculatorAction.DoCalculation)
    }
    val onCommaClicked: () -> Unit = {
        viewModel.checkInput(CalculatorAction.Comma)
    }
    val onPlusClicked: () -> Unit = {
        viewModel.checkInput(CalculatorAction.SetOperator(Operators.PLUS))
    }
    val onMinusClicked: () -> Unit = {
        viewModel.checkInput(CalculatorAction.SetOperator(Operators.MINUS))
    }
    val onMultiplyClicked: () -> Unit = {
        viewModel.checkInput(CalculatorAction.SetOperator(Operators.MULTIPLY))
    }
    val onDivideClicked: () -> Unit = {
        viewModel.checkInput(CalculatorAction.SetOperator(Operators.DIVIDE))
    }
    val onNumberClicked: (int: Int) -> Unit = {
        viewModel.checkInput(CalculatorAction.SetNumber(viewModel.numbers[it]))
    }


    val sumOfInput by animateIntAsState(
        targetValue = viewModel.calculatedSum.value.toInt(),
        tween(
            durationMillis = 1000
        )
    )
    Column(
        Modifier
            .fillMaxSize()
            .background(color = BackgroundColor)
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(30.dp),
            verticalArrangement = Arrangement.Top,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                text = "The Crapculator",
                fontWeight = FontWeight.Bold,
                fontSize = 30.sp,
                color = Color.White,
            )
            quoteViewModel.data.value?.let {
                Column {
                    Text(
                        text = "${it.sentence} - ${it.character.name}",
                        fontWeight = FontWeight.Medium,
                        fontSize = 14.sp,
                        color = Color.White
                    )
                }
            }
        }
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(20.dp),
            verticalArrangement = Arrangement.Bottom,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Box(
                modifier = Modifier
                    .background(color = ButtonColor)
                    .size(height = 150.dp, width = 355.dp)
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
                        .clickable() {
                            onClearClicked()
                        },
                    operator = "CLEAR",
                )
                CalculatorOperatorButton(
                    modifier = modifierSmallBox
                        .clickable { onDivideClicked() },
                    operator = "/"
                )
            }
            Row(
                modifier = fillMaxWidthModifier,
                horizontalArrangement = Arrangement.Center
            ) {
                CalculatorNumberButton(
                    modifier = modifierSmallBox
                        .clickable { onNumberClicked(0) },
                    "?"
                )
                CalculatorNumberButton(
                    modifier = modifierSmallBox
                        .clickable { onNumberClicked(1) },
                    "?"
                )
                CalculatorNumberButton(
                    modifier = modifierSmallBox
                        .clickable { onNumberClicked(2) },
                    "?"
                )
                CalculatorOperatorButton(
                    modifier = modifierSmallBox
                        .clickable { onMultiplyClicked() },
                    operator = "*"
                )
            }
            Row(
                modifier = fillMaxWidthModifier,
                horizontalArrangement = Arrangement.Center
            ) {
                CalculatorNumberButton(
                    modifier = modifierSmallBox
                        .clickable { onNumberClicked(3) },
                    "?"
                )
                CalculatorNumberButton(
                    modifier = modifierSmallBox
                        .clickable { onNumberClicked(4) },
                    "?"
                )
                CalculatorNumberButton(
                    modifier = modifierSmallBox
                        .clickable { onNumberClicked(5) },
                    "?"
                )
                CalculatorOperatorButton(
                    modifier = modifierSmallBox
                        .clickable { onMinusClicked() },
                    operator = "-"
                )
            }
            Row(
                modifier = fillMaxWidthModifier,
                horizontalArrangement = Arrangement.Center
            ) {
                CalculatorNumberButton(
                    modifier = modifierSmallBox
                        .clickable { onNumberClicked(6) },
                    "?"
                )
                CalculatorNumberButton(
                    modifier = modifierSmallBox
                        .clickable { onNumberClicked(7) },
                    "?"
                )
                CalculatorNumberButton(
                    modifier = modifierSmallBox
                        .clickable { onNumberClicked(8) },
                    "?"
                )
                CalculatorOperatorButton(
                    modifier = modifierSmallBox
                        .clickable { onPlusClicked() },
                    operator = "+"
                )
            }
            Row(
                modifier = fillMaxWidthModifier,
                horizontalArrangement = Arrangement.Center
            ) {
                CalculatorNumberButton(
                    modifier = modifierMediumBox
                        .clickable { onNumberClicked(9) },
                    "?"
                )
                CalculatorOperatorButton(
                    modifier = modifierSmallBox
                        .clickable { onCommaClicked() },
                    operator = "."
                )
                CalculatorOperatorButton(
                    modifier = modifierSmallBox
                        .clickable { onEqualsClicked() },
                    operator = "="
                )
            }
        }
    }

}