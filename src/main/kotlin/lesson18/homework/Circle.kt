package com.pavel.likholap.lesson18.homework

import kotlin.math.PI

class Circle(private val radius: Double): Shape() {
    override fun area(): Double {
        return PI * (radius * radius)
    }
}