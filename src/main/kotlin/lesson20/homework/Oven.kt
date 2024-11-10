package com.pavel.likholap.lesson20.homework

class Oven(maxTemp: Int) : ControlledOpenableDevice(maxTemp) {

    fun bake() {
        if (isTurnedOn) println("Oven is baking")
    }

    override fun setTemperature(temp: Int) {
        if (isTurnedOn) currentTemperature = temp
    }

    override fun open() {
        println("Oven is opened")
    }


}