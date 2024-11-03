package com.pavel.likholap.lesson18.homework


class LaserPrinter: Printer() {
    override fun printString(str: String) {
        for (word in splitString(str)){
            println("${Colors.BLACK}${Background.WHITE}$word${Colors.RESET}")
        }
    }
}