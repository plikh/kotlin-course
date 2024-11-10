package com.pavel.likholap.lesson20.homework

abstract class PowerDevice: Powerable {
    protected var isTurnedOn = false

    override fun powerOn() {
        isTurnedOn = true
        println("Device is turned on")
    }
    override fun powerOff() {
        isTurnedOn = false
        println("Device is turned off")
    }
}

