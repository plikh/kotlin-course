package com.pavel.likholap.lesson21.homework


//Создай класс OddValidator и имплементируй интерфейс Validator типизированный по Int.
//Реализуй проверку, что число чётное.

class OddValidator: Validator<Int> {
    override fun checker(value: Int): Boolean {
        return value % 2 == 0
    }
}

