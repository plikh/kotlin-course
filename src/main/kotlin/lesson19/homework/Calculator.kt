package com.pavel.likholap.lesson19.homework

import kotlin.math.pow

class Calculator(customOperations: List<Operation> = listOf()) {
    private val operations = listOf(Add(), Subtract(), Multiply(), Divide(), DivideRem()) + customOperations
    fun operate(expression: String): String {
        val operator = operations.firstOrNull { it.checkOperator(expression) }
        return operator?.operate(expression) ?: throw Exception("Needed operation is not found")
    }

}

private class Add : Operation("+") {
    override fun operate(expression: String): String {
        val operands = parseString(expression)
        return (operands.first + operands.second).toString()
    }
}

private class Subtract : Operation("-") {
    override fun operate(expression: String): String {
        val operands = parseString(expression)
        return (operands.first - operands.second).toString()
    }
}

private class Multiply : Operation("*") {
    override fun operate(expression: String): String {
        val operands = parseString(expression)
        return (operands.first * operands.second).toString()
    }
}

private class Divide : Operation("/") {
    override fun operate(expression: String): String {
        val operands = parseString(expression)
        if (operands.second == 0.0) throw Exception("Zero division error")
        return (operands.first / operands.second).toString()
    }
}

private class DivideRem : Operation("%") {
    override fun operate(expression: String): String {
        val operands = parseString(expression)
        if (operands.second == 0.0) throw Exception("Zero division error")
        return (operands.first % operands.second).toString()
    }
}

private class Power : Operation("**") {
    override fun operate(expression: String): String {
        val operands = parseString(expression)
        return (operands.first.pow(operands.second)).toString()
    }
}


fun main() {
    val calculator = Calculator(listOf(Power()))
    println(calculator.operate("34 + 34"))
    println(calculator.operate("3456 - 322"))
    println(calculator.operate("8 * 11"))
    println(calculator.operate("3490 / 1234"))
    println(calculator.operate("45 % 4"))
    println(calculator.operate("10 ** 3"))
    println(calculator.operate("qwerty + zxcvb"))

}