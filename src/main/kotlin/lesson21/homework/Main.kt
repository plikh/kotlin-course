package com.pavel.likholap.lesson21.homework



//Создайте функцию toMap<K, V>(keys: List<K>, values: List<V>): Map<K, V>, которая будет создавать карту из списков
//ключей и значений. Если ключей или значений больше, то оставшиеся ключи или значения не записываем в словарь.
fun <K, V> toMap(keys: List<K>, values: List<V>): Map<K, V>{
    return keys.zip(values).toMap()
}

//Напишите функцию getMiddleElement<T>(list: List<T>): T?,
//которая будет возвращать средний элемент списка, если он существует.

fun <T> getMiddleElement(list: List<T>): T?{
    return if (list.size % 2 != 0) list[list.size/2] else null
}



fun main(){
    println("         ".isNullOrBlank())
    println("         ".isNullOrEmpty())
}