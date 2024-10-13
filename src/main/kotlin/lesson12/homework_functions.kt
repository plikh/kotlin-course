package com.pavel.likholap.lesson12

fun main(){

    println(multiplyByTwo(3))

    println(isEven(45))
    println(isEven(66))

    println(printNumbersUntil(0))
    println(printNumbersUntil(12))

    println(findFirstNegative(listOf(1, 2, 3, 4, 5, -1, -2, -3)))
    println(findFirstNegative(listOf(1, 2, 3)))

    println(processList(listOf("1","2", null, "3", "4")))
    println(processList(listOf("5","6", "null", "7", "9")))
    drawRectangle(width=12, height=13)



}
////////////////////////////Напиши валидную сигнатура метода//////////////////////////////////////////////////

//Напишите сигнатуру функции, которая не принимает аргументов и не возвращает значения.
fun emptyFun() = Unit

//Напишите сигнатуру функции, которая принимает два целых числа и возвращает их сумму.
fun getSum(a: Int, b: Int) = a + b

//Напишите сигнатуру функции, которая принимает строку и ничего не возвращает
fun emptyString(str: String) = Unit

//Напишите сигнатуру функции, которая принимает список целых чисел и возвращает среднее значение типа Double
fun getAverage(lstDigits: List<Int>): Double{
    return 1.0
}

//Напишите сигнатуру функции, которая принимает nullable строку и возвращает её длину в виде nullable целого числа.
fun getLength(str: String?): Int?{
    return null
}

//Напишите сигнатуру функции, которая не принимает аргументов и возвращает nullable вещественное число
fun getDigit(): Int?{
    return null
}

//Напишите сигнатуру функции, которая принимает nullable список целых чисел и не возвращает значения.
fun nullList(lst: List<Int>?) = Unit

//Напишите сигнатуру функции, которая принимает целое число и возвращает nullable строку.
fun getStr(dig: Int): String?{
    return null
}

//Напишите сигнатуру функции, которая не принимает аргументов и возвращает список nullable строк
fun getNullListStrings(): List<String?>{
    return listOf()
}

//Напишите сигнатуру функции, которая принимает nullable строку и nullable целое
//число и возвращает nullable булево значение.
fun getBool(str: String?, dig: Int?): Boolean?{
    return null
}

//////////////////////////////////Напиши рабочий код для следующих задач://///////////////////////////////////////////

//Задача 1:
//Напишите функцию multiplyByTwo, которая принимает целое число и возвращает его, умноженное на 2.
fun multiplyByTwo(dig: Int) = dig *2

//Задача 2:
//Создайте функцию isEven, которая принимает целое число и возвращает true, если число чётное,
// и false в противном случае.
fun isEven(dig: Int): Boolean{
    return dig % 2 == 0
}

//Задача 3:
//Напишите функцию printNumbersUntil, которая принимает целое число n и выводит на экран числа от 1 до n.
//Если число n меньше 1, функция должна прекратить выполнение с помощью return без вывода сообщений.
fun printNumbersUntil(n: Int){
    if (n < 1){
        return
    }
    for (i in 1..n) {
        println(i)
    }
}

//Задача 4:
//Создайте функцию findFirstNegative, которая принимает список целых чисел и
//возвращает первое отрицательное число в списке. Если отрицательных чисел нет, функция должна вернуть null.
fun findFirstNegative(lst: List<Int>): Int?{
    for (i in lst){
        if (i < 0){
            return i
        }
    }
    return null
}

//Задача 5:
//Напишите функцию processList, которая принимает список строк.
//Функция должна проходить по списку и выводить каждую строку. Если встречается null значение,
//функция должна прекратить выполнение с помощью return без возврата значения.
fun processList(lst: List<String?>){
    for (i in lst){
        if (i == null){return }
        println(i)
    }

}


//Сделай рефакторинг функции, через определение вспомогательных приватных функций.
//Требуется избавиться от дублирования кода и трудно воспринимаемых фрагментов.

private fun rectangleArgumentsChecker(width: Int, height: Int){
    val commonText = "должно быть положительным и больше нуля"
    when {
        width <= 0 -> throw IllegalArgumentException("width $commonText")
        height <= 0 -> throw IllegalArgumentException("height $commonText")
    }
}

private fun drawHorizontalLine(lineSize: Int){
    var line = "+"
    for (i in 1 until lineSize - 1) {
        line += "-"
    }
    line += "+\n"
    print(line)
}

private fun drawVerticalLines(lineSize: Int, spaceSize: Int){
    for (i in 1 until spaceSize - 1) {
        var middleLine = "|"
        for (j in 1 until lineSize - 1) {
            middleLine += " "
        }
        middleLine += "|\n"
        print(middleLine)
    }
}

fun drawRectangle(width: Int, height: Int) {
    rectangleArgumentsChecker(width, height)
    drawHorizontalLine(width)
    drawVerticalLines(width, height)
    drawHorizontalLine(width)
}
