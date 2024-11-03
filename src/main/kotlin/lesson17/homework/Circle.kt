package com.pavel.likholap.lesson17.homework

import kotlin.math.PI

class Circle(
    private val radius: Int,

    ): Figure() {
    fun getArea(): Double{
        return PI * (radius * radius)
    }
}