package com.skym.calculator.presentation.calculator

sealed class CalculatorAction() {
    data class Number(val number: String) : CalculatorAction()
    object Delete : CalculatorAction()
    object Clear : CalculatorAction()
    object Calculate : CalculatorAction()
    data class Operation(val operation: CalculatorOperation) : CalculatorAction()
}
