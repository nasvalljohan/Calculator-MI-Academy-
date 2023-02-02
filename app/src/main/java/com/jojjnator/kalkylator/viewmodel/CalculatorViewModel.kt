package com.jojjnator.kalkylator.viewmodel

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import com.jojjnator.kalkylator.CalculatorUtilAction
import com.jojjnator.kalkylator.CalculatorOperatorAction

class CalculatorViewModel : ViewModel() {

    // TODO: Send events from UI to viewModel.
    // Event for numbers pressed
    // Event for clear pressed
    // Event for operations
    // Event for decimal
    // Event for doing the calculation

    var state = mutableStateOf("")
        private set

    var state2 = mutableStateOf("")
        private set

    var operator = mutableStateOf("")
        private set

    fun checkUtilInput(action: CalculatorUtilAction) {
        when (action) {
            is CalculatorUtilAction.Clear -> {
                state.value = ""
                state2.value = ""
                operator.value = ""
            }
            is CalculatorUtilAction.DoCalculation -> {
                if (operator.value == "+") {

                    state.value.toInt() + state2.value.toInt()
                }
                if (operator.value == "-") {
                    state.value.toInt() - state2.value.toInt()
                }
                if (operator.value == "*") {
                    state.value.toInt() * state2.value.toInt()
                }
                if (operator.value == "/") {
                    state.value.toDouble() / state2.value.toDouble()
                }
            }
            is CalculatorUtilAction.Comma -> {

            }
        }
    }

    fun checkOperatorInput(operatorInput: CalculatorOperatorAction) {
        when (operatorInput) {
            is CalculatorOperatorAction.Divide -> {
                operator.value = "/"
            }
            is CalculatorOperatorAction.Add -> {
                operator.value = "+"
            }
            is CalculatorOperatorAction.Subtract -> {
                operator.value = "-"
            }
            is CalculatorOperatorAction.Multiply -> {
                operator.value = "*"
            }
        }
    }

    fun checkNumberInput(number: Int){

    }

}