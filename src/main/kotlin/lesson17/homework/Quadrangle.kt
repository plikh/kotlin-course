package com.pavel.likholap.lesson17.homework

class Quadrangle(private val base: Double,
                 private val height: Double) {

    fun getPerimeter(): Double{
        return (base * 2)  + (height * 2)
    }

    fun getArea(): Double{
        return base * height
    }
}