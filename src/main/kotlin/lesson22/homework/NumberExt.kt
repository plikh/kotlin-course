package com.pavel.likholap.lesson22.homework
import kotlin.math.absoluteValue


fun Number.within(other: Number, deviation: Number): Boolean {
    val difference = (this.toDouble() - other.toDouble()).absoluteValue
    return difference <= deviation.toDouble()
}