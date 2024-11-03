package com.pavel.likholap.lesson18.homework

class Triangle(
    private val height: Double,
    private val base: Double): Shape()   {
    override fun area(): Double {
         return (base * height)/2
    }
}