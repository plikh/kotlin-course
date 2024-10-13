package com.pavel.likholap.lesson12

fun main(){
    printMap(12, 13)
}

//Сделай рефакторинг функции, которую разбирали на уроке и устрани баг,
//из-за которого таблица разъезжается при разных размерностях аргументов

private fun mapArgumentsChecker(xSize: Int, ySize: Int){
    val commonText = "не должно быть равным нулю"
    when {
        xSize == 0 -> throw IllegalArgumentException("xSize $commonText")
        ySize == 0 -> throw IllegalArgumentException("ySize $commonText")
    }
}

private fun getIntProgression(size: Int): IntProgression{
    return when {
        size > 0 -> 0..size
        else -> 0 downTo size
    }
}

private fun getSymbol(a: Int, b: Int): String{
    return when {
        a % 2 == 0 -> if (a % 3 == 0) "." else "*"
        a % 5 == 0 -> if (b < 0) "-" else "+"
        else -> "?"
    }
}

private fun printStringNeededLength(neededLength: Int, symbol: Any){
    print(symbol.toString().padStart(neededLength))
}

fun printMap(xSize: Int, ySize: Int) {
    mapArgumentsChecker(xSize, ySize)
    val formatterSize = " $xSize".length + 1
    val xRange = getIntProgression(xSize)
    val yRange = getIntProgression(ySize)

    print(" ".repeat(formatterSize))
    for (i in yRange) {
        printStringNeededLength(formatterSize, i)
    }
    println()
    for (i in xRange) {
        printStringNeededLength(formatterSize, i)
        for (j in yRange) {
            val m = i * j
            val result = getSymbol(m, i)
            printStringNeededLength(formatterSize, result)
        }
        println()
    }
}