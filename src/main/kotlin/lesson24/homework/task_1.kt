package com.pavel.likholap.lesson24.homework

//Задание 1. Воспроизвести фрагменты кода, которые могут привести к возникновению исключений:
fun main() {

//NullPointerException
    null!!

//ArrayIndexOutOfBoundsException
    arrayOf(1, 2)[2]

//ClassCastException
    12 as String

//NumberFormatException
    "str".toInt()

//IllegalArgumentException
    require(12 < 0)

//IllegalStateException
    check(12 < 0)

//OutOfMemoryError
    val list = mutableListOf<String>()
    while (true) {
        list.add("1234567890-=12345667890")
    }


}