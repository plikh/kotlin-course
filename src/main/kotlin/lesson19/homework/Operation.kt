package com.pavel.likholap.lesson19.homework

abstract class Operation(private val operator: String) {
    abstract fun operate(expression: String): String


    private fun isDouble(str: String): Boolean {
        return str.toDoubleOrNull() != null
    }

    fun checkOperator(expression: String): Boolean {
        return expression.contains(" $operator ")
    }


    protected fun parseString(expression: String): Pair<Double, Double> {
        val operands = expression.split(operator).toMutableList()
        if (operands.size != 2) throw Exception("Invalid operands or operator")
        if (operands.all { isDouble(it) }) return Pair(operands[0].toDouble(),operands[1].toDouble())
        else throw Exception("Invalid operands: Current realization supports operations only with numbers")

    }

}
