package com.pavel.likholap.lesson15.homework


/*
Событие: Вечеринка Создайте класс Party, который описывает вечеринку.
У него должны быть свойства location (String) и attendees (Int).
Добавьте метод details(), который выводит информацию о месте проведения и количестве гостей.
 */

class Party(private val location: String, private val attendees : Int) {
    fun details(){
        println("Party place: $location; Guests amount: $attendees ")
    }
}