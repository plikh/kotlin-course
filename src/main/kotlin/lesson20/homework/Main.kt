package com.pavel.likholap.lesson20.homework

import java.io.InputStream

interface Powerable {
    fun powerOn()
    fun powerOff()
}

interface Openable {
    fun open()
    fun close()
}

interface WaterContainer {
    val capacity: Int
    fun fillWater(amount: Int)
    fun getWater(amount: Int)
}

interface TemperatureRegulatable {
    val maxTemperature: Int
    fun setTemperature(temp: Int)
}

interface AutomaticShutdown {
    val sensorType: String
    val maxSensoredValue: Int
    fun startMonitoring()
}

interface Drainable {
    fun connectToDrain()
    fun drain()
}

interface Timable {
    fun setTimer(time: Int)
}

interface BatteryOperated {
    fun getCapacity(): Double
    fun replaceBattery()
}

interface Mechanical {
    fun performMechanicalAction()
}

interface LightEmitting {
    fun emitLight()
    fun completeLiteEmission()
}

interface SoundEmitting {
    fun setVolume(volume: Int)
    fun mute()
    fun playSound(stream: InputStream)
}

interface Programmable {
    fun programAction(action: String)
    fun execute()
}

interface Movable {
    fun move(direction: String, distance: Int)
}

interface Cleanable {
    fun clean()
}

interface Rechargeable {
    fun getChargeLevel(): Double
    fun recharge()
}

/*
Создай абстрактные классы устройств, используя эти интерфейсы. Реализовывать методы не нужно.
Холодильник
Стиральная машина
Умная лампа
Электронные часы
Робот-пылесос
Механические часы
Фонарик
Кофемашина
Умная колонка
*/

abstract class Refrigerator1 : Powerable, TemperatureRegulatable, Openable

abstract class WashMachine1 : Powerable, TemperatureRegulatable, Openable, WaterContainer, Drainable, Programmable

abstract class SmartLamp : Powerable, LightEmitting

abstract class DigitalClock : Powerable, Timable

abstract class RobotVacuum : Powerable, Movable, Cleanable, Rechargeable

abstract class MechanicalClock : Mechanical, Timable

abstract class Flashlight : Powerable, LightEmitting, BatteryOperated

abstract class CoffeeMachine : Powerable, WaterContainer, TemperatureRegulatable, Programmable

abstract class SmartSpeaker : Powerable, SoundEmitting, Programmable


fun main(){
    val fridge = Refrigerator(5)
    fridge.powerOn()
    fridge.setTemperature(3)
    fridge.open()

    val wash = WashMachine(91)
    wash.powerOn()
    wash.fillWater(30)
    wash.setTemperature(40)
    wash.programAction("Wash")

    val kettle = Kettle(2, 90)
    kettle.powerOn()
    kettle.fillWater(1)
    kettle.setTemperature(90)
    kettle.boil()


    val oven = Oven(220)
    oven.powerOn()
    oven.setTemperature(180)
    oven.bake()
    oven.powerOff()
}