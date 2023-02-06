package com.jojjnator.kalkylator

import com.jojjnator.kalkylator.viewmodel.Operators


sealed interface CalculatorAction {

    object Clear : CalculatorAction
    object Comma : CalculatorAction
    object DoCalculation : CalculatorAction
    data class SetOperator(val operator: Operators) : CalculatorAction
    data class SetNumber(val number: Int) : CalculatorAction

}

