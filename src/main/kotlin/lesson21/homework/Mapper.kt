package com.pavel.likholap.lesson21.homework


//Создайте интерфейс Mapper<T, R>, который будет определять метод для преобразования элементов типа T в элементы типа R.

interface Mapper<T, R> {
    fun changeItemType(item: T): R

//Добавь к интерфейсу Mapper ещё один метод, который будет
// преобразовывать список элементов типа T в список элементов типа R.
// Реализуй этот метод в классе PhrasesToListOfStrings с аналогичной механикой.

    fun changeListItems(items: List<T>): List<R>
}