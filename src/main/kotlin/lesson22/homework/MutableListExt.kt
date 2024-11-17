package com.pavel.likholap.lesson22.homework

fun <T> MutableList<T?>.getExt(one: T?, two: Int): T?{
    one ?: this.add(one)
    return if (two in this.indices) this[two] else null
}