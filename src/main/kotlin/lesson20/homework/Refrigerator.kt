package com.pavel.likholap.lesson20.homework

class Refrigerator(maxTemp: Int) : ControlledOpenableDevice(maxTemp) {
    fun getCool() {
        if (isTurnedOn) {
            println("Refrigerator is working")
        }
    }

    override fun setTemperature(temp: Int) {
        if (isTurnedOn) currentTemperature = temp
    }

    override fun open() {
        println("Refrigerator is opened")
    }
}