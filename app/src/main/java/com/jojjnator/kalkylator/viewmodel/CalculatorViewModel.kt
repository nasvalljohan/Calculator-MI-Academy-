package com.jojjnator.kalkylator.viewmodel

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import com.jojjnator.kalkylator.CalculatorAction

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

    fun checkInput(action: CalculatorAction) {
        when (action) {
            is CalculatorAction.Clear -> {
                state.value = ""
                state2.value = ""
                operator.value = ""
            }
            is CalculatorAction.DoCalculation -> {
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
            is CalculatorAction.Comma -> {

            }

            is CalculatorAction.SetNumber -> {

            }

            is CalculatorAction.SetOperator -> {

            }
        }
    }
}

