package com.pavel.likholap.lesson20.homework

class WashMachine(maxTemp: Int) : ControlledOpenableDevice(maxTemp), WaterContainer, Drainable {
    override val capacity: Int = 50
    private var waterLevel: Int = 0
    private var isConnectedToDrain = false

    private fun wash() {
        if (isTurnedOn) println("Machine is washing")
    }

    override fun fillWater(amount: Int) {
        if (isTurnedOn) {
            waterLevel += amount
        }
    }

    override fun getWater(amount: Int) {
        if (waterLevel >= amount) waterLevel -= amount
    }


    override fun connectToDrain() {
        if (isTurnedOn)
            isConnectedToDrain = true
        println("Machine is connected to drain")

    }

    override fun drain() {
        if (isTurnedOn && isConnectedToDrain)
            waterLevel = 0
        println("Drain is performed")
    }

    override fun setTemperature(temp: Int) {
        if (isTurnedOn) currentTemperature = temp
    }

    override fun open() {
        println("Wash machine is opened")
    }


}