package com.jojjnator.kalkylator.viewmodel

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import com.jojjnator.kalkylator.interfaces.CalculatorAction

class CalculatorViewModel : ViewModel() {

    var secondInput = mutableStateOf("")
        private set
    var firstInput = mutableStateOf("")
        private set
    var operator = mutableStateOf("")
        private set
    var calculatedSum = mutableStateOf(0.0)
        private set
    var numbers = mutableListOf(1, 2, 3, 4, 5, 6, 7, 8, 9, 0)
        private set

    fun checkInput(actionFromUI: CalculatorAction) {
        when (actionFromUI) {
            is CalculatorAction.Clear -> {
                operator.value = ""
                secondInput.value = ""
                firstInput.value = ""
                calculatedSum.value = 0.0
                crapTheCulator()
            }
            is CalculatorAction.DoCalculation -> doCalculation(operatorInput = operator.value)

            is CalculatorAction.Comma -> addCommaToDigit()

            is CalculatorAction.SetNumber -> setNumberFromAction(
                operatorInput = operator.value,
                action = actionFromUI
            )

            is CalculatorAction.SetOperator -> operator.value = actionFromUI.operator.stringOP
        }
    }
    private fun crapTheCulator() {
        numbers = numbers.shuffled().toMutableList()
    }

    private fun setNumberFromAction(operatorInput: String, action: CalculatorAction.SetNumber) {
        if (operatorInput.isEmpty()) {
            if (firstInput.value.isEmpty() && action.number == 0) {
                return
            }
            firstInput.value += action.number
        }
        if (operatorInput.isNotEmpty()) {
            if (firstInput.value.isEmpty() && action.number == 0) {
                return
            }
            secondInput.value += action.number
        }
    }

    private fun addCommaToDigit() {
        if (secondInput.value.isNotEmpty()) {
            secondInput.value += "."
        }
        if (secondInput.value.isEmpty() && operator.value.isEmpty() && firstInput.value.isNotEmpty()) {
            firstInput.value += "."
        }
    }

    private fun doCalculation(operatorInput: String) {
        if (operatorInput == Operators.PLUS.stringOP) {
            calculatedSum.value = firstInput.value.toDouble() + secondInput.value.toDouble()
        }
        if (operatorInput == Operators.MULTIPLY.stringOP) {
            calculatedSum.value = firstInput.value.toDouble() * secondInput.value.toDouble()
        }
        if (operatorInput == Operators.DIVIDE.stringOP) {
            calculatedSum.value = firstInput.value.toDouble() / secondInput.value.toDouble()
        }
        if (operatorInput == Operators.MINUS.stringOP) {
            calculatedSum.value = firstInput.value.toDouble() - secondInput.value.toDouble()
        }
    }

}

enum class Operators(val stringOP: String) {
    PLUS("+"),
    MINUS("-"),
    MULTIPLY("*"),
    DIVIDE("/")
}



