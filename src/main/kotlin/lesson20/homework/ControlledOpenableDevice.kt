package com.pavel.likholap.lesson20.homework

abstract class ControlledOpenableDevice(maxTemp: Int) : ProgrammableDevice(), TemperatureRegulatable, Openable {
    override var maxTemperature: Int = maxTemp
    protected var currentTemperature: Int? = null
    private var isOpen = false

    override fun open() {
        isOpen = true
        println("Device is opened")
    }

    override fun close() {
        isOpen = false
        println("Device is closed")
    }

    override fun setTemperature(temp: Int) {
        currentTemperature = temp
    }
}