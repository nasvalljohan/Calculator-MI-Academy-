package com.jojjnator.kalkylator

sealed class CalculatorUtilAction() {

    object Clear: CalculatorUtilAction()
    object Comma: CalculatorUtilAction()
    object DoCalculation: CalculatorUtilAction()

}
