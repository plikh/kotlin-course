package com.pavel.likholap.lesson17.homework

class OfficeChair(material: String, weight: Double) : Chair(material, weight) {
    fun getType(): String {
        return "This is a office chair"
    }
}