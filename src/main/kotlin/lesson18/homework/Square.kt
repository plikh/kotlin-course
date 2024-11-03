package com.pavel.likholap.lesson18.homework

class Square(private val base: Double, private val height: Double): Shape() {
    override fun area(): Double {
        return  base * height
    }
}