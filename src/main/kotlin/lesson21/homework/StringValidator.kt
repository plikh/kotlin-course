package com.pavel.likholap.lesson21.homework

//Создай класс StringValidator и имплементируй
// интерфейс Validator с типом String?. Реализуй проверку, что строка не является null, н
// е пустая и не состоит из одних пробелов.

class StringValidator: Validator<String?> {
    override fun checker(value: String?): Boolean {
        return value.isNullOrBlank()
    }
}