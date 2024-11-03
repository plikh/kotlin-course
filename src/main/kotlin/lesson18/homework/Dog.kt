package com.pavel.likholap.lesson18.homework



class Dog(name: String): Animal(name) {
    override fun makeSound() {
        println("${Colors.PURPLE}$name Bark${Colors.RESET}")
    }
}