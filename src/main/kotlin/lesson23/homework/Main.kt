package com.pavel.likholap.lesson23.homework

/*
Напишите функцию analyzeDataType, принимающую параметр типа Any. Функция должна определить тип аргумента и вывести соответствующее сообщение:
Для строки: "Это строка: [значение]".
Для целого числа: "Это целое число: [значение]".
Для списка: "Это список, количество элементов: [количество]".
Для карты: "Это карта, количество пар: [количество]".
Для остальных типов: "Неизвестный тип данных".
Используйте оператор is для проверки типов.
*/

fun analyzeDataType(arg1: Any): String {
    return when (arg1) {
        is String -> "Это строка: $arg1"
        is Int -> "Это целое число: $arg1"
        is List<*> -> "Это список, количество элементов: ${arg1.size}"
        is Map<*, *> -> "Это карта, количество пар: ${arg1.entries.size}"
        else -> "Неизвестный тип данных"
    }
}

/*
Создайте функцию safeCastToList, принимающую параметр типа Any и возвращающую размер списка,
если аргумент можно безопасно привести к типу List. В случае неудачного приведения функция должна возвращать -1.
Используйте as? для безопасного приведения типа.
 */

fun safeCastToList(arg1: Any): Int {
    val a = arg1 as? List<*>
    return a?.size ?: -1
}

/*
Создайте функцию getStringLengthOrZero, которая принимает параметр типа Any? и возвращает длину строки,
если аргумент можно привести к типу String. В случае, если аргумент равен null или не является строкой,
функция должна возвращать 0.
 */

fun getStringLengthOrZero(arg1: Any?): Int {
    val a = arg1 as? String
    return a?.length ?: 0
}

/*
Создайте функцию, которая принимает параметр типа Any.
Функция гарантированно ожидает число (в виде числа или строки, например 4 или 4.2 или “4.2”)
и должна вернуть квадрат этого числа. Если придёт число, его нужно возвести в квадрат, если придёт строка,
то его нужно преобразовать в число через функцию toDouble() и возвести в квадрат.
 */

fun getSq(arg1: Any): Number {
    val a = when (arg1) {
        is String -> arg1.toDouble()
        is Number -> arg1.toDouble()
        else -> throw Exception("Some error")
    }
    return a * a
}

/*
Задача 5
Напишите функцию sumIntOrDoubleValues, которая принимает список элементов типа Any и возвращает сумму всех
 целочисленных (Int) и вещественных (Double) значений в списке. Все остальные типы должны быть проигнорированы.
 */

fun sumIntOrDoubleValues(l: List<Any>): Double {
    return l.mapNotNull  {
        when (it) {
            is Int -> it.toDouble()
            is Double -> it
            else -> null
        }
    }.sum()
}

/*
Задача 6
Создайте функцию tryCastToListAndPrint, которая принимает параметр типа Any и пытается привести его к
типу List<*>. Если приведение успешно, функция должна напечатать все строки из списка, если элемент не
является строкой то вывести предупреждение об этом. Если приведение неудачно, должно быть выведено сообщение об ошибке,
 не прерывая выполнение программы.
 */

fun tryCastToListAndPrint(arg: Any){
    (arg as? List<*>)?.forEach { println((it as? String) ?: "элемент неявляется строкой")}
}


fun main(){
    listOf(1, "1", mapOf(1 to 1, 2 to 2), listOf(1, 2, 4), 1 to 5).forEach { println(analyzeDataType(it)) }

    println(safeCastToList(listOf(1, 2, 4)))
    println(safeCastToList(12))

    println(getStringLengthOrZero(23))
    println(getStringLengthOrZero("Hello"))

    println(getSq(4.2))
    println(getSq("100"))

    println(sumIntOrDoubleValues(listOf(123.0, 1, "1", mapOf(1 to 1, 2 to 2), listOf(1, 2, 4), 1 to 5)))

    tryCastToListAndPrint(listOf("123", "1", mapOf(1 to 1, 2 to 2), listOf(1, 2, 4), 1 to 5, "some string"))
}