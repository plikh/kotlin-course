package com.pavel.likholap.lesson24.homework


/*
Задание 3. Оберни все вызовы из предыдущего задания в блок try-catch с одним блоком catch для любого типа исключений.
Внутри блока catch, используя when, напиши для каждого исключения вывод в консоль специфического сообщения,
подходящего под каждый из типов.
*/

fun main() {
    for (i in listOf(
        { check(12 < 0) },
        { null!! },
        { "str".toInt() },
        { 12 as String },
        { arrayOf(1, 2)[2] },
        { require(12 < 0) },
        { getStackOverflowError() },
        {
            val list = mutableListOf<String>()
            while (true) {
                list.add("1234567890-=12345667890")
            }
        })) {
        try {
            i()
        } catch (e: Throwable) {
            when (e) {
                is NullPointerException -> println("NullPointerException was raised")
                is ArrayIndexOutOfBoundsException -> println("ArrayIndexOutOfBoundsException was raised")
                is ClassCastException -> println("ClassCastException was raised")
                is NumberFormatException -> println("NumberFormatException was raised")
                is IllegalArgumentException -> println("IllegalArgumentException was raised")
                is IllegalStateException -> println("IllegalStateException was raised")
                is OutOfMemoryError -> println("OutOfMemoryError was raised")
                is StackOverflowError -> println("StackOverflowError was raised")
                else -> println("UnknownError was raised")

            }


        }
    }
}