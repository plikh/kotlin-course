package com.pavel.likholap.lesson10

fun main(){

//Задание 1: Создание Пустого Списка
//Создайте пустой неизменяемый список целых чисел.
    val lst1: List<Int> = listOf()

//Задание 2: Создание и Инициализация Списка
//Создайте неизменяемый список строк, содержащий три элемента (например, "Hello", "World", "Kotlin").
    val lst2: List<String> = listOf("Hello", "World", "Kotlin")

//Задание 3: Создание Изменяемого Списка
//Создайте изменяемый список целых чисел и инициализируйте его значениями от 1 до 5.
    val lst3: MutableList<Int> = mutableListOf(1, 2, 3, 4, 5)

//Задание 4: Добавление Элементов в Список
//Имея изменяемый список целых чисел, добавьте в него новые элементы (например, 6, 7, 8).
    val lst4: MutableList<Int> = mutableListOf()
    for (i in 6..8)
        lst4.add(i)

//Задание 5: Удаление Элементов из Списка
//Имея изменяемый список строк, удалите из него определенный элемент (например, "World").
    val lst5: MutableList<String> = mutableListOf("1", "2", "3")
    lst5.remove("1")

//Задание 6: Перебор Списка в Цикле
//Создайте список целых чисел и используйте цикл для вывода каждого элемента на экран.
    for (i in listOf(1, 3, 5, 7, "some", "123")){
        println(i)
    }

//Задание 7: Получение Элементов Списка по Индексу
//Создайте список строк и получите из него второй элемент, используя его индекс.
    println(listOf("one", "two", "three").elementAt(1))

//Задание 8: Перезапись Элементов Списка по Индексу
// Имея изменяемый список чисел, измените значение элемента на определенной позиции
// (например, замените элемент на позиции 2 на новое значение)
    val lst8: MutableList<Double> = mutableListOf(2.0, 5.9, 3.9087)
    lst8[2] = 109.78

//Задание 9: Объединение Двух Списков
//Создайте два списка строк и объедините их в один новый список, содержащий элементы обоих списков.
// Реши задачу с помощью циклов.
    val lst9: MutableList<String> =  mutableListOf("qwe", "rty", "uio")
    val lst91: MutableList<String> =  mutableListOf("asd", "fgh", "jkl")
    val lst92: MutableList<String> = mutableListOf()
    for (i in lst9.indices){
        lst92.add(lst9[i])
        lst92.add(lst91[i])
    }

//Задание 10: Нахождение Минимального/Максимального Элемента
//Создайте список целых чисел и найдите в нем минимальный и максимальный элементы используя цикл.
    fun findMax(lst: List<Int>): Int? {
        var max: Int? = null
        for (i in lst) {
            if (max == null) {
                max = i
            } else if (max < i) max = i

        }
    return max}

    fun findMin(lst: List<Int>): Int? {
        var min: Int? = null
        for (i in lst) {
            if (min == null) {
                min = i
            } else if (min > i) min = i

        }
        return min}

//Задание 11: Фильтрация Списка
//Имея список целых чисел, создайте новый список, содержащий только четные числа из исходного списка используя цикл.
    val lst11: MutableList<Int> = mutableListOf()
    for (i in listOf(1, 2, 45, 67, 78, 8, 0)){
        if (i % 2 == 0){
            lst11.add(i)
        }
    }

}