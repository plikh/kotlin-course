package com.pavel.likholap.lesson22.homework

fun Array<Int>.getCountAndAverage(): Pair<Int, Double> {
    return Pair(this.size, this.average())
}
