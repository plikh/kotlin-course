package com.pavel.likholap.lesson22.homework

fun Long?.getLongStr(): String{
    return (this?.plus(1L)).toString()
}