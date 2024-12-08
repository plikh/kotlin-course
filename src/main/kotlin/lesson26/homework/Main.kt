package com.pavel.likholap.lesson26.homework

//Напишите функцию, которая принимает другую функцию без аргументов и возвращаемого значения.

fun one(arg: () -> Unit) = Unit


//Создайте функцию, принимающую функцию с одним аргументом типа Int и возвращающую String.

fun two(arg: (Int) -> String) = Unit


//Реализуйте функцию, принимающую функцию расширения типа Int, принимающую String и возвращающую Boolean.

fun three(arg: Int.(String) -> Boolean) = Unit


//Напишите функцию, которая принимает функцию с двумя аргументами типа Double и возвращает Boolean.

fun four(arg: (Double, Double) -> Boolean) = arg(1.0, 2.0)


//Напишите функцию, которая принимает функцию с одним аргументом-дженериком T и возвращает List<T>.

fun <T> five(arg: (T) -> List<T>) = Unit


//Создайте функцию, принимающую функцию с аргументом типа String и возвращающую другую функцию,
//принимающую Int и возвращающую Boolean.

fun six(arg: (String) -> (Int) -> Boolean) = arg("123")


//Напишите функцию, которая принимает список чисел, множество строк,
//функцию с аргументами типа List<Int> и Set<String> и возвращающую Map<String, Int>.

fun <N, S> seven(arg1: List<N>, arg2: Set<S>, arg3: (List<N>, Set<S>) -> Map<S, N>) = arg3(arg1, arg2)


//Напишите функцию, возвращающую строку, принимающую число и функцию, принимающую число и возвращающую строку

fun eight(arg1: Int, arg2: (Int) -> String) = arg2(arg1)


//Напишите функцию, принимающую функцию, которая возвращает функцию без аргументов и возвращаемого значения.

fun nine(arg: () -> () -> Unit) = arg()()


//Напишите функцию filterStrings, которая принимает список строк и функцию-фильтр, оставляющую только строки,
// удовлетворяющие условию (то-есть принимающая строку и возвращающая булево значение). Функция должна вернуть
// результат фильтрации исходного списка строк.

fun filterStrings(strings: List<String>, filter: (String) -> Boolean): List<String> {
    return strings.filter(filter)
}


//Создайте функцию applyToNumbers, которая принимает список чисел и функцию,
// преобразующую каждое число в другое число (те-есть принимающая число и возвращающая число).
// Функция должна вернуть результат преобразования исходного списка чисел.

fun <T, R> applyToNumbers(numbers: List<T>, transform: (T) -> R): List<R> {
    return numbers.map(transform)
}


//Реализуйте функцию sumByCondition, которая принимает список чисел и функцию,
//определяющую условие для включения числа в сумму. Функция должна вернуть сумму чисел, прошедших проверку.

fun <T> sumByCondition(numbers: List<T>, includeCondition: (T) -> Boolean): Int {
    return numbers
        .filter(includeCondition)
        .mapNotNull { (it as? Number)?.toInt() }
        .sum()
}


//Напишите функцию combineAndTransform, которая принимает две коллекции одного типа и
//функцию для их объединения и преобразования в одну коллекцию другого типа.
//Функция должна вернуть результат преобразования (коллекцию второго типа)

fun <T, K, C1 : Collection<T>, C2 : Collection<K>> unionCollections(arg1: C1, arg2: C1, arg3: (C1, C1) -> C2): C2 {
    return arg3(arg1, arg2)


}


fun main() {
    val checkLength = { str: String ->
        str.length == 3
    }

    val checkSymbol = { str: String ->
        str.contains('a')
    }

    println(filterStrings(listOf("qwert", "assddd", "a", "asd"), checkLength))
    println(filterStrings(listOf("qwert", "assddd", "a", "123"), checkSymbol))


    val toDouble = { num: Int ->
        num.toDouble()
    }

    val toLong = { num: Double ->
        num.toLong()
    }

    println(applyToNumbers(listOf(1, 2, 3), toDouble))
    println(applyToNumbers(listOf(17.0, 22.9, 3.003), toLong))


    val moreZero = { num: Int ->
        num > 0
    }

    val lessZero = { num: Int ->
        num < 0
    }

    println(sumByCondition(listOf(-1, 2, 0, 33), moreZero))
    println(sumByCondition(listOf(-12, 12, 33, -33), lessZero))


    val getSet = { a: List<Int>, b: List<Int> ->
        (a + b).toSet()
    }

    val getMutableList = { a: List<String>, b: List<String> ->
        (a + b).toMutableList()
    }


    println(unionCollections(listOf(1, 2, 3), listOf(1, 2, 3), getSet))
    println(unionCollections(listOf("1", "2", "3"), listOf("qww", "asd", "asd"), getMutableList))

}

