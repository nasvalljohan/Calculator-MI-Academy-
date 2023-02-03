package com.jojjnator.kalkylator

sealed interface CalculatorAction {

    object Clear : CalculatorAction
    object Comma : CalculatorAction
    object DoCalculation : CalculatorAction
    data class SetOperator(val operator: Operators) : CalculatorAction
    data class SetNumber(val number: Digits) : CalculatorAction

}

enum class Digits(digit: String) {
    ONE("1"),
    TWO("2"),
    THREE("3"),
    FOUR("4"),
    FIVE("5"),
    SIX("6"),
    SEVEN("7"),
    EIGHT("8"),
    NINE("9"),
    ZERO("0")
}

enum class Operators(operator: String) {
    MULTIPLY("*"),
    DIVIDE("/"),
    ADD("+"),
    SUBTRACT("-"),
}