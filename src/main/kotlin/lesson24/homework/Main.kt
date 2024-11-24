package com.pavel.likholap.lesson24.homework

fun main() {

    throw CustomErrorFirst("It's first custom error class")

    try {
        arrayOf(1, 2)[34]
    } catch (e: ArrayIndexOutOfBoundsException) {
        println(e.message)
        throw CustomErrorSecond(e)
    }

}