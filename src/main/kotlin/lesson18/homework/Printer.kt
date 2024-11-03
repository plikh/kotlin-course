package com.pavel.likholap.lesson18.homework

abstract class Printer {
    abstract fun printString(str: String)
    protected fun splitString(str: String): List<String>{
        return str.split(" ")
    }
}