package com.pavel.likholap.lesson18.homework


class Bird(name: String): Animal(name) {
    override fun makeSound() {
        println("${Colors.YELLOW}$name Tweet${Colors.RESET}")
    }
}