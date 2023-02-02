package com.jojjnator.kalkylator

sealed class CalculatorOperatorAction {

    object Multiply: CalculatorOperatorAction(){
        val multiply = "*"
    }
    object Divide: CalculatorOperatorAction(){
        val divide = "/"
    }
    object Add: CalculatorOperatorAction(){
        val add = "+"
    }
    object Subtract: CalculatorOperatorAction(){
        val subtract = "-"
    }
}
