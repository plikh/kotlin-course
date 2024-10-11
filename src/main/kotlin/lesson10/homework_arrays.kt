package com.pavel.likholap.lesson10



fun main() {

//Задание 1: Создание и Инициализация Массива
//Создайте массив из 5 целых чисел и инициализируйте его значениями от 1 до
    val arr1 = IntArray(5) { i -> (i + 1) }

//Задание 2: Создание Пустого Массива
//Создайте пустой массив строк размером 10 элементов.
    val arr2 = arrayOfNulls<String?>(10)


//Задание 3: Заполнение Массива в Цикле
//Создайте массив из 5 элементов типа Double и заполните его значениями, являющимися удвоенным индексом элемента.
    val arr3 = DoubleArray(5)
    for (i in arr3.indices) {
        arr3[i] = i * 2.0
    }

//Задание 4: Изменение Элементов Массива
//Создайте массив из 5 элементов типа Int. Используйте цикл,
// чтобы присвоить каждому элементу значение, равное его индексу, умноженному на 3.
    val arr4: Array<Int> = arrayOf(1, 2, 3, 4, 5)
    for (i in arr4.indices) {
        arr4[i] = i * 3
    }


//Задание 5: Работа с Nullable Элементами
//Создайте массив из 3 nullable строк. Инициализируйте его одним null значением и двумя строками.
    val arr5 = arrayOfNulls<String?>(3)
    for (i in arr5.indices) {
        arr5[i] = if (i == 0) null else "somestring"
    }

//Задание 6: Копирование Массива
//Создайте массив целых чисел и скопируйте его в новый массив в цикле.
    val arr6: Array<Double> = arrayOf(1.0, 2.0, 3.0)
    val arr7 = DoubleArray(3)
    for (i in arr6) {
        arr7[arr6.indexOf(i)] = i
    }

//Задание 7: Разница Двух Массивов
//Создайте два массива целых чисел одинаковой длины. Создайте третий массив, вычев значения одного из другого.
    val arr8: Array<Int> = arrayOf(34, 56, 78, 987, 9013)
    val arr9: Array<Int> = arrayOf(89, 34, 432, 780, 12343)
    val arr10 = IntArray(5)
    for (i in arr8.indices) {
        arr10[i] = arr8[i] - arr9[i]
    }

//Задание 8: Поиск Индекса Элемента
//Создайте массив целых чисел. Найдите индекс элемента со значением 5. Если значения 5 нет в массиве,
// возвращаем -1. Реши задачу через цикл while.
    fun findIndex(value: Any, array: Array<Any>): Int {
        var result = -1
        var counter = 0
        while (counter < array.size) {
            if (array[counter] == value) {
                result = counter
                break
            } else counter++
        }
        return result}

//Задание 9: Перебор Массива
//Создайте массив целых чисел. Используйте цикл для перебора массива и вывода каждого элемента в консоль.
// Напротив каждого элемента должно быть написано “чётное” или “нечётное”.
    for (i in arrayOf(123, 245, 24, 67, 23, 66, 87, 123, 56)){
        println("$i ${if (i % 2 == 0) "четное" else "нечетное"}")
    }

//Задание 10: Поиск Значения в Массиве по вхождению
//Создай функцию, которая принимает массив строк и строку для поиска. Функция должна находить в массиве элемент,
//в котором принятая строка является подстрокой (метод contains()). Верни найденный элемент из функции в виде строки.
    fun findString(str: String, array: Array<String>): String{
        var result = "Array doesn't contain elements with $str substring"

        for (i in array){
            if (i.contains(str)){
                result = i
                break
            }
        }
        return result
    }
}