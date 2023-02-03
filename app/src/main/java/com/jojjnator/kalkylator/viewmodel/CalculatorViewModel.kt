package com.jojjnator.kalkylator.viewmodel

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import com.jojjnator.kalkylator.CalculatorAction


class CalculatorViewModel : ViewModel() {

    var secondInput = mutableStateOf("")
        private set
    var firstInput = mutableStateOf("")
        private set
    var operator = mutableStateOf("")
        private set

    var calculatedSum = mutableStateOf(0.0)
        private set

    fun checkInput(action: CalculatorAction) {
        when (action) {
            is CalculatorAction.Clear -> {
                operator.value = ""
                secondInput.value = ""
                firstInput.value = ""
                calculatedSum.value = 0.0
            }
            is CalculatorAction.DoCalculation -> {
                if (action.operator == "+") {
                    calculatedSum.value = firstInput.value.toDouble() + secondInput.value.toDouble()
                }
                if (action.operator == "*") {
                    calculatedSum.value = firstInput.value.toDouble() * secondInput.value.toDouble()
                }
                if (action.operator == "/") {
                    calculatedSum.value = firstInput.value.toDouble() / secondInput.value.toDouble()
                }
                if (action.operator == "-") {
                    calculatedSum.value = firstInput.value.toDouble() - secondInput.value.toDouble()
                }
            }
            is CalculatorAction.Comma -> {
                if (secondInput.value.isNotEmpty()) {
                    secondInput.value += "."
                }
                if (secondInput.value.isEmpty() && operator.value.isEmpty() && firstInput.value.isNotEmpty()) {
                    firstInput.value += "."
                }
            }

            is CalculatorAction.SetNumber -> {
                if (operator.value.isEmpty()) {
                    firstInput.value += action.number
                }
                if (operator.value.isNotEmpty()) {
                    secondInput.value += action.number
                }
            }
            is CalculatorAction.SetOperator -> {
                operator.value = action.operator

            }
        }
    }
}

