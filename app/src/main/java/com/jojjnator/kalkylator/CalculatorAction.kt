package com.jojjnator.kalkylator

sealed interface CalculatorAction {

    object Clear : CalculatorAction
    object Comma : CalculatorAction
    data class DoCalculation(val operator: String) : CalculatorAction
    data class SetOperator(val operator: String) : CalculatorAction
    data class SetNumber(val number: Int) : CalculatorAction

}

