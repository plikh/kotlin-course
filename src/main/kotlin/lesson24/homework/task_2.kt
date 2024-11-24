package com.pavel.likholap.lesson24.homework


//Задание 2. Оберни все вызовы из предыдущего задания в блок try-catch и создай для каждого типа ошибки свой catch блок

fun main() {
    try {
        null!!
    } catch (e: NullPointerException) {
        println("NullPointerException was raised")
    }


    try {
        arrayOf(1, 2)[2]
    } catch (e: ArrayIndexOutOfBoundsException) {
        println("ArrayIndexOutOfBoundsException was raised")
    }

    try {
        12 as String
    } catch (e: ClassCastException) {
        println("ClassCastException was raised")
    }

    try {
        "str".toInt()
    } catch (e: NumberFormatException) {
        println("NumberFormatException was raised")
    }

    try {
        require(12 < 0)
    } catch (e: IllegalArgumentException) {
        println("IllegalArgumentException was raised")
    }

    try {
        check(12 < 0)
    } catch (e: IllegalStateException) {
        println("IllegalStateException was raised")
    }

    try {
        val list = mutableListOf<String>()
        while (true) {
            list.add("1234567890-=12345667890")
        }
    } catch (e: OutOfMemoryError) {
        println("OutOfMemoryError was raised")
    }

    try {
        getStackOverflowError()
    } catch (e: StackOverflowError) {
        println("StackOverflowError was raised")
    }

}

fun getStackOverflowError() {
    getStackOverflowError()
}