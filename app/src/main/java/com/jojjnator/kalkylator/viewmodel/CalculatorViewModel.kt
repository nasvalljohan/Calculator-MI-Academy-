package com.jojjnator.kalkylator.viewmodel

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import com.jojjnator.kalkylator.CalculatorAction


class CalculatorViewModel : ViewModel() {

    var secondInput = mutableStateOf(0)
        private set
    var firstInput = mutableStateOf(0)
        private set
    var operator = mutableStateOf("")
        private set

    var calculatedSum = mutableStateOf(0)
        private set

    fun checkInput(action: CalculatorAction) {
        when (action) {
            is CalculatorAction.Clear -> {
                operator.value = ""
                secondInput.value = 0
                firstInput.value = 0
                calculatedSum.value = 0
            }
            is CalculatorAction.DoCalculation -> {
                if (action.operator == "+") {
                    calculatedSum.value = firstInput.value + secondInput.value
                }
                if (action.operator == "*") {
                    calculatedSum.value = firstInput.value * secondInput.value
                }
                if (action.operator == "/") {
                    calculatedSum.value = firstInput.value / secondInput.value
                }
                if (action.operator == "-") {
                    calculatedSum.value = firstInput.value - secondInput.value
                }
            }
            is CalculatorAction.Comma -> {
                secondInput.value.toDouble()
                firstInput.value.toDouble()
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


enum class Digit(number: Int) {
    ZERO(0),
    ONE(1),
    TWO(2),
    THREE(3),
    FOUR(4),
    FIVE(5),
    SIX(6),
    SEVEN(7),
    EIGHT(8),
    NINE(9),

}

enum class Operator(operator: String) {
    MULTIPLY("*"),
    DIVIDE("/"),
    ADD("+"),
    SUBTRACT("-"),
}

