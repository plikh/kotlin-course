package com.pavel.likholap.lesson17.homework

class Triangle(
    private val height: Double,
    private val base: Double,
    private val sideOne: Double,
    private val sideTwo: Double): Polygon()  {

    fun getPerimeter(): Double{
        return base + sideOne + sideTwo
    }

    fun getArea(): Double{
        return (base * height)/2
    }
}