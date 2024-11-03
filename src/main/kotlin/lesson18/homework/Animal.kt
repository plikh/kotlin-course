package com.pavel.likholap.lesson18.homework


abstract class Animal(val name: String) {
    open fun makeSound() = println("This animal makes no sound.")
}

