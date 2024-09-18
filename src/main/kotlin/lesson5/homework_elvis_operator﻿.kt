package com.pavel.likholap.lesson5


fun main(){
    printSoundIntensity(47.713, 0.348)
    printSoundIntensity(24.092, null)

    printShippingPrice(100457.0)
    printShippingPrice(null)

    checkAtmospherePressure(970.0)
    checkAtmospherePressure(null)
}


fun printSoundIntensity(startIntensity: Double, koef: Double?){
    println(startIntensity * (koef ?: 0.5))
}

fun printShippingPrice(loadPrice: Double?){
    println(0.005 * (loadPrice ?: 10000.0))
}

fun checkAtmospherePressure(atmPressure: Double?){
    atmPressure ?: throw Exception("Atmosphere pressure is absent")
}