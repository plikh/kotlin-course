package com.pavel.likholap.lesson20.homework

abstract class ProgrammableDevice : PowerDevice(), Programmable {
    private var isActionProgrammed = false

    override fun programAction(action: String) {
        if (isTurnedOn) {
            isActionProgrammed = true
            println("Action is programmed: $action")
        }
    }

    override fun execute() {
        if (isTurnedOn && isActionProgrammed) println("Action is executed")
    }
}