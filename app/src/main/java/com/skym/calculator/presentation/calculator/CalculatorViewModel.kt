package com.skym.calculator.presentation.calculator

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel

class CalculatorViewModel : ViewModel() {

     var state by mutableStateOf(CalculatorState())
         private set

    fun onAction(action: CalculatorAction) {
        when (action) {
            CalculatorAction.Calculate -> calculate()
            CalculatorAction.Clear -> state = CalculatorState()
            CalculatorAction.Delete -> delete()
            is CalculatorAction.Number -> typeNumber(action.number)
            is CalculatorAction.Operation -> typeOperation(action.operation)
        }
    }

    private fun delete() {
        if (state.numberOne.isNotEmpty() && state.operation == null) {
            state = state.copy(numberOne = state.numberOne.dropLast(1))
        }
        if (state.numberTwo.isNotEmpty()) {
            state = state.copy(numberTwo = state.numberTwo.dropLast(1))
        }
        if (state.operation != null) {
            state = state.copy(operation = null)
        }
    }

    private fun typeNumber(type: String) {
        state = if (state.operation == null) {
            state.copy(numberOne = state.numberOne + type)
        } else {
            state.copy(numberTwo = state.numberTwo+ type)
        }
    }

    private fun typeOperation(operation: CalculatorOperation) {
        if (state.numberOne.isEmpty()) {
            return
        }

        if (state.numberOne.isNotEmpty() && state.numberTwo.isEmpty()) {
            state = state.copy(operation = operation)
        }

        if (state.numberTwo.isNotEmpty()) {
            return
        }

        if (state.operation != null) {
            return
        }
    }

    private fun calculate() {
        val numberOne = state.numberOne.toDoubleOrNull()
        val numberTwo = state.numberTwo.toDoubleOrNull()
        val operation = state.operation
        if (numberOne == null || numberTwo == null) {
            return
        }
        when (operation) {
            CalculatorOperation.Add -> {
                state = state.copy(
                    result = (numberOne + numberTwo).toString(),
                    numberOne = "",
                    numberTwo = "",
                    operation = null
                )
            }

            CalculatorOperation.Divide -> {
                state = state.copy(
                    result = (numberOne / numberTwo).toString(),
                    numberOne = "",
                    numberTwo = "",
                    operation = null
                )
            }
            CalculatorOperation.Multiply -> {
                state = state.copy(
                    result = (numberOne * numberTwo).toString(),
                    numberOne = "",
                    numberTwo = "",
                    operation = null
                )
            }
            CalculatorOperation.Subtract -> {
                state = state.copy(
                    result = (numberOne * numberTwo).toString(),
                    numberOne = "",
                    numberTwo = "",
                    operation = null
                )
            }
            null -> return
        }
    }
}

