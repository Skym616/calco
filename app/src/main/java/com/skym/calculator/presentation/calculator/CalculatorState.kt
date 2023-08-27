package com.skym.calculator.presentation.calculator

data class CalculatorState(
    val numberOne: String = "",
    val numberTwo: String = "",
    val operation: CalculatorOperation? = null,
    val result: String = "0"
)