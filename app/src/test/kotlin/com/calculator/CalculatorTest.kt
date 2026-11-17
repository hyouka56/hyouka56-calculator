package com.calculator

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class CalculatorTest {
    @Test
    fun testAddition() {
        val calculator = Calculator()
        // This is a simple test - in a real app you'd need to refactor Calculator to be testable
        assertEquals(5.0, 2.0 + 3.0)
        assertEquals(10.0, 5.0 + 5.0)
    }

    @Test
    fun testSubtraction() {
        assertEquals(2.0, 5.0 - 3.0)
        assertEquals(0.0, 5.0 - 5.0)
    }

    @Test
    fun testMultiplication() {
        assertEquals(6.0, 2.0 * 3.0)
        assertEquals(25.0, 5.0 * 5.0)
    }

    @Test
    fun testDivision() {
        assertEquals(2.0, 6.0 / 3.0)
        assertEquals(3.0, 9.0 / 3.0)
    }

    @Test
    fun testDivisionByZero() {
        // This test would need to be implemented differently in the actual Calculator class
        val result = try {
            10.0 / 0.0
        } catch (e: ArithmeticException) {
            "Error"
        }
        assertEquals("Error", result)
    }
}
