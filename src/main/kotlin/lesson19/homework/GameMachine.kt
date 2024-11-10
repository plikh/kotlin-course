package com.pavel.likholap.lesson19.homework

class GameMachine(
    var color: String,
    val model: String,
    private var isPoweredOn: Boolean = false,
    private var isOSLoaded: Boolean = false,
    private val gamesList: MutableList<String>,
    private var hasJoystick: Boolean,
    private var balance: Double = 0.0,
    private var owner: String,
    var supportPhone: String
) {
    private fun powerOn(): Boolean {
        isPoweredOn = true
        loadOS()
        return isPoweredOn
    }

    private fun powerOff() {
        isPoweredOn = false
        isOSLoaded = false
    }

    private fun loadOS() {
        if (isPoweredOn) {
            isOSLoaded = true
        }
    }

    fun selectGame(game: String): Boolean {
        return isOSLoaded && gamesList.contains(game)
    }

    private fun addBalance(amount: Double) {
        if (amount > 0) balance += amount
    }

    private fun getBalance(): Double {
        return balance
    }

    fun checkJoystick(): Boolean {
        return hasJoystick
    }
}