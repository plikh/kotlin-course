package com.pavel.likholap.lesson22.homework

fun main(){
    val ar = arrayOf(1, 2, 3, 4, 5)
    println(ar.getCountAndAverage())

    val char: Char? = null
    char.getNothing(1, 2, true)

    val mtList: MutableList<Int?> = mutableListOf(1, 2, 3, 4)
    println(mtList.getExt(3, 1))

    val extMap: Map<Int, List<Int>>? = mapOf(1 to listOf(1, 2, 3), 4 to listOf(1, 2))
    println(extMap.getMapExt(4))

    val long: Long? = 1234444444
    println(long.getLongStr())

    val pair: Pair<Int, Int>? = Pair(1, 2)
    val pair1: Pair<Int, Int>? = null
    println(pair.revert())
    println(pair1.revert())

    val intAbs = 12346
    println(intAbs.within(4456, 455))

    val floatAbs = 12f
    println(floatAbs.within(34f, 908f))

    val doubleAbs = 1222.2989
    println(doubleAbs.within(1222.9, 78.0))

    println("What's up my friends".encrypt(3))
    println("Zkdw*v#xs#p|#iulhqgv".decrypt(3))

    "fddfgdfgdfgdfgdfg".getNameAndLetter(listOf("one", "two", "three", "four", "five", "six"))

}