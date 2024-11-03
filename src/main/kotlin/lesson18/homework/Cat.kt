package com.pavel.likholap.lesson18.homework


class Cat(name: String): Animal(name) {
    override fun makeSound() {
        println("${Colors.BLUE}$name Meow${Colors.RESET}")
    }
}