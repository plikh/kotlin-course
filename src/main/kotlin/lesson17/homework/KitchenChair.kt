package com.pavel.likholap.lesson17.homework

class KitchenChair(material: String, weight: Double) : Chair(material, weight) {
    fun getType(): String {
        return "This is a kitchen chair"
    }
}