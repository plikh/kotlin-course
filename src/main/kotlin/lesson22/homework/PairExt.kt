package com.pavel.likholap.lesson22.homework

fun <T, R> Pair<T, R>?.revert(): Pair<R, T>? {
    return if (this != null) Pair(this.second, this.first) else null
}