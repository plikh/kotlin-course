package com.pavel.likholap.lesson25.homework

const val A = "Some text to print"

fun main() {

    printStr()
    fPrintStr()
    fPrintStr1()
    fPrintStr2()

    println(getAverage(listOf(1, 3, 4, 7)))
    println(fGetAverage(listOf(12, 44, 490, 7)))
    println(fGetAverage1(listOf(0, -1, -2, 2)))
    println(fGetAverage2(listOf()))

    println(getStringsByLength(listOf("wds", "poiu5", "q"), 2))
    println(fGetStringsByLength(listOf("s", "cvbn8", "q"), 12))
    println(fGetStringsByLength1(listOf("", "`", "qwerty"), 1))
    println(fGetStringsByLength2(listOf(), 91))

    println(getDigitSum(1234567890345678903))
    println(fGetDigitSum(999999999999999999))
    println(fGetDigitSum1(12))
    println(fGetDigitSum2(1234560976555555677))

    println(listOf(1, 1, 3, 3, 34, 5, 55, 55).getDistinct())
    println(listOf(1, 1, 1).fGetDistinct())
    println(listOf(1, 1, 1, 2, 3, 44, 44, 44).fGetDistinct1())

    println(mapOf("zxcv" to 11, "tyjukfiugkfyjuhytrf" to 12, "2222" to 1, "``poiujhh``" to 16).getMapKeys(45))
    println(mapOf("qwert" to 10, "xdfghjkghj" to 123, "vbn" to 1, "poiujhh" to 3).fGetMapKeys(2))
    println(mapOf("qwert" to 10, "xdfghjkghj" to 123, "vbn" to 1, "poiujhh" to 3).fGetMapKeys1(6))

    println(
        mapOf(listOf(1, 2, 3) to setOf("qwe", "rty")).allIn(
            12, 2f, 32L, 3.0, 1, "some text", 'a', "a" to 1, arrayOf(1, 2, 4),
            listOf(1, 2, "4"), setOf(4, 5, 6), mapOf(1 to 2 to null), true, null
        )
    )

    println(
        mapOf(listOf(1, 2, 3) to setOf("qwe", "rty")).fAllIn(
            12, 2f, 32L, 3.0, 1, "some text", 'a', "a" to 1, arrayOf(1, 2, 4),
            listOf(1, 2, "4"), setOf(4, 5, 6), mapOf(1 to 2 to null), true, null
        )
    )

    println(
        mapOf(listOf(1, 2, 3) to setOf("qwe", "rty")).fAllIn1(
            12, 2f, 32L, 3.0, 1, "some text", 'a', "a" to 1, arrayOf(1, 2, 4),
            listOf(1, 2, "4"), setOf(4, 5, 6), mapOf(1 to 2 to null), true, null
        )
    )


}

/*
Задание 1. Создай константу в файле с текстом. Создай функцию, которая ничего не принимает и не возвращает
и печатает в консоль текст константы. Создай аналогичную анонимную функцию.Создай аналогичное лямбда выражение
с указанием типа. Создай лямбда выражение без указания типа.
Проверь как функция работает
*/

fun printStr() {
    println(A)
}

val fPrintStr = fun() {
    println(A)
}

val fPrintStr1: () -> Unit = { println(A) }

val fPrintStr2 = { println(A) }


/*
Задание 2. Создай функцию, которая принимает список чисел и возвращает среднее арифметическое этого списка.
С помощью require проверь, что список не пустой.
Создай аналогичную анонимную функцию.
Создай аналогичное лямбда выражение с указанием типа.
Создай лямбда выражение без указания типа.
Проверь, что лямбда выражение работает правильно с помощью нескольких наборов данных (в том числе пустого).
 */

fun getAverage(lst: List<Int>): Double {
    require(lst.isNotEmpty())
    return lst.average()
}

val fGetAverage = fun(lst: List<Int>): Double {
    require(lst.isNotEmpty())
    return lst.average()
}

val fGetAverage1: (List<Int>) -> Double = { lst ->
    require(lst.isNotEmpty())
    lst.average()
}

val fGetAverage2 = { lst: List<Int> ->
    require(lst.isNotEmpty())
    lst.average()
}


/*
Задание 3. Создай функцию, которая принимает список строк и число, а возвращает
список из строк, длина которых больше или равна заданному числу. Если список пуст, нужно выкинуть исключение.
По аналогии с предыдущим заданием выполни трансформации и проверки.
 */

fun getStringsByLength(lst: List<String>, length: Int): List<String> {
    if (lst.isEmpty()) throw EmptyListError()
    return lst.filter { it.length >= length }
}

val fGetStringsByLength = fun(lst: List<String>, length: Int): List<String> {
    if (lst.isEmpty()) throw EmptyListError()
    return lst.filter { it.length >= length }
}

val fGetStringsByLength1: (List<String>, Int) -> List<String> = { lst, length ->
    if (lst.isEmpty()) throw EmptyListError()
    lst.filter { it.length >= length }
}

val fGetStringsByLength2 = { lst: List<String>, length: Int ->
    if (lst.isEmpty()) throw EmptyListError()
    lst.filter { it.length >= length }
}


/*
Задание 4. Создай функцию, которая принимает большое число и возвращает сумму цифр этого числа.
По аналогии с предыдущим заданием выполни трансформации и проверки.
Подсказка: для парсинга строки “3” в число 3 можно использовать “3”.digitToInt()
 */

fun getDigitSum(dig: Long): Int {
    return dig.toString().map { it.digitToInt() }.sum()
}

val fGetDigitSum = fun(dig: Long): Int {
    return dig.toString().map { it.digitToInt() }.sum()
}

val fGetDigitSum1: (Long) -> Int = { dig ->
    dig.toString().map { it.digitToInt() }.sum()
}

val fGetDigitSum2 = { dig: Long ->
    dig.toString().map { it.digitToInt() }.sum()
}


/*
Задание 5. Создай функцию расширение списка чисел, которая будет возвращать список уникальных чисел (без дубликатов).
Создай аналогичную анонимную функцию.
Создай аналогичное лямбда выражение с указанием типа.
Проверь, что лямбда выражение работает правильно с помощью нескольких наборов данных.
*/

fun List<Int>.getDistinct(): List<Int> {
    return distinct()
}

val fGetDistinct = fun List<Int>.(): List<Int> {
    return distinct()
}

val fGetDistinct1: List<Int>.() -> List<Int> = { distinct() }


/*
Задание 6. Создай функцию расширение словаря из строк и чисел, которая принимает число и
возвращает список ключей, длина которых меньше их значений но больше заданного в функции аргумента.
В случае если список получается пустой нужно выкинуть исключение IllegalState.
По аналогии с предыдущим заданием выполни трансформации и проверки.
*/

fun Map<String, Int>.getMapKeys(num: Int): List<String> {
    val keysList = mapNotNull { if (num < it.key.length && it.key.length < it.value) it.key else null }
    check(keysList.isNotEmpty()) { "List is empty after filtering" }
    return keysList
}

val fGetMapKeys = fun Map<String, Int>.(num: Int): List<String> {
    val keysList = mapNotNull { if (num < it.key.length && it.key.length < it.value) it.key else null }
    check(keysList.isNotEmpty()) { "List is empty after filtering" }
    return keysList
}

val fGetMapKeys1: Map<String, Int>.(Int) -> List<String> = { num ->
    val keysList = mapNotNull { if (num < it.key.length && it.key.length < it.value) it.key else null }
    check(keysList.isNotEmpty()) { "List is empty after filtering" }
    keysList
}


/*
Задание 7. Создай функцию расширения словаря из списка и множества, которая принимает все известные тебе
типы (вспомни все что знаешь и под каждый тип создай аргумент) и возвращает строку.
Функция должна распечатать все данные, которые тебе в ней доступны и вернуть конкатенацию
всех данных которые ей доступны (порядок неважен). Конкатенация - это присоединение.
Код должен быть отформатирован таким образом, чтобы легко читался.
По аналогии с предыдущим заданием выполни трансформации.
*/

fun Map<List<Int>, Set<String>>.allIn(
    int: Int, flt: Float, lng: Long, dbl: Double, sht:
    Short, str: String, chr: Char, pr: Pair<*, *>, arr: Array<*>,
    lst: List<*>, set: Set<*>, map: Map<*, *>, bln: Boolean, nl: Any?
): String {
    return """
        Data from main object -> $keys; $values;
        Numbers -> Int: $int; Float: $flt; Long: $lng; Double: $dbl; Short: $sht;
        Strings -> String: $str; Char: $chr;
        Collections -> Array: ${arr.contentToString()}; List: $lst; Set: $set; Map: $map;
        Others -> Boolean: $bln; Pair: $pr; Null: $nl

    """.trimIndent()
}

val fAllIn = fun Map<List<Int>, Set<String>>.(
    int: Int, flt: Float, lng: Long, dbl: Double, sht:
    Short, str: String, chr: Char, pr: Pair<*, *>, arr: Array<*>,
    lst: List<*>, set: Set<*>, map: Map<*, *>, bln: Boolean, nl: Any?
): String {
    return """
        Data from main object -> $keys; $values;
        Numbers -> Int: $int; Float: $flt; Long: $lng; Double: $dbl; Short: $sht;
        Strings -> String: $str; Char: $chr;
        Collections -> Array: ${arr.contentToString()}; List: $lst; Set: $set; Map: $map;
        Others -> Boolean: $bln; Pair: $pr; Null: $nl

    """.trimIndent()
}


val fAllIn1: Map<List<Int>, Set<String>>.(
    Int, Float, Long, Double, Short, String, Char, Pair<*, *>, Array<*>,
    List<*>, Set<*>, Map<*, *>, Boolean, Any?
) -> String = { int, flt, lng, dbl, sht, str,
                chr, pr, arr, lst, set, map, bln, nl ->
    """
        Data from main object -> $keys; $values;
        Numbers -> Int: $int; Float: $flt; Long: $lng; Double: $dbl; Short: $sht;
        Strings -> String: $str; Char: $chr;
        Collections -> Array: ${arr.contentToString()}; List: $lst; Set: $set; Map: $map;
        Others -> Boolean: $bln; Pair: $pr; Null: $nl

    """.trimIndent()
}
