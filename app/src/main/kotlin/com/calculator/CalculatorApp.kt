package com.calculator

fun main() {
    val calculator = Calculator()
    calculator.start()
}

class Calculator {
    private var currentInput = ""
    private var previousInput = ""
    private var operation: String? = null
    private var shouldResetDisplay = false

    fun start() {
        println("=== Kotlin Calculator ===")
        println("Enter numbers and operations (+, -, *, /)")
        println("Type 'exit' to quit, 'clear' to reset")
        println("==========================")

        while (true) {
            print("> ")
            val input = readLine()?.trim() ?: ""

            when {
                input.lowercase() == "exit" -> {
                    println("Goodbye!")
                    break
                }
                input.lowercase() == "clear" -> {
                    clearCalculator()
                    println("Calculator cleared")
                }
                input in listOf("+", "-", "*", "/") -> {
                    handleOperation(input)
                }
                else -> {
                    try {
                        val number = input.toDouble()
                        handleNumber(number)
                    } catch (e: NumberFormatException) {
                        println("Invalid input. Please enter a number or operation.")
                    }
                }
            }
        }
    }

    private fun handleNumber(number: Double) {
        if (shouldResetDisplay) {
            currentInput = ""
            shouldResetDisplay = false
        }
        currentInput = currentInput + number
        println("Display: $currentInput")
    }

    private fun handleOperation(op: String) {
        if (currentInput.isNotEmpty()) {
            if (operation != null) {
                calculateResult()
            }
            previousInput = currentInput
            operation = op
            currentInput = ""
            shouldResetDisplay = true
            println("Operation: $op")
        }
    }

    private fun calculateResult() {
        if (previousInput.isNotEmpty() && currentInput.isNotEmpty() && operation != null) {
            try {
                val num1 = previousInput.toDouble()
                val num2 = currentInput.toDouble()
                val result = when (operation) {
                    "+" -> num1 + num2
                    "-" -> num1 - num2
                    "*" -> num1 * num2
                    "/" -> {
                        if (num2 != 0.0) {
                            num1 / num2
                        } else {
                            println("Error: Division by zero")
                            return
                        }
                    }
                    else -> return
                }
                println("Result: $result")
                currentInput = result.toString()
                previousInput = ""
                operation = null
                shouldResetDisplay = true
            } catch (e: Exception) {
                println("Calculation error: ${e.message}")
            }
        }
    }

    private fun clearCalculator() {
        currentInput = ""
        previousInput = ""
        operation = null
        shouldResetDisplay = false
    }
}
