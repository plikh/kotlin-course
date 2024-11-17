package com.pavel.likholap.lesson21.homework


//Напишите класс ListHolder, который будет хранить список элементов типа T
//и иметь метод для добавления и получения всех элементов.

class ListHolder<T> {
    val list = mutableListOf<T>()

    fun addItem(item: T){
        list.add(item)
    }

    fun getItems(): String{
        return list.joinToString("; ")
    }
}