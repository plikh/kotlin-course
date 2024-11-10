package com.pavel.likholap.lesson20.homework

class Kettle(kettleCapacity: Int, maxTemp: Int) : ControlledOpenableDevice(maxTemp), WaterContainer {
    override val capacity: Int = kettleCapacity
    private var waterLevel: Int = 0

    override fun fillWater(amount: Int) {
        waterLevel += amount
    }

    override fun getWater(amount: Int) {
        if (waterLevel >= amount) waterLevel -= amount
    }

    fun boil() {
        if (isTurnedOn && waterLevel > 0) {
            println("Kettle is boiling")
        }
    }

    override fun setTemperature(temp: Int) {
        if (isTurnedOn) currentTemperature = temp
    }

    override fun open() {
        println("Kettle is opened")
    }


}