package com.pavel.likholap.lesson17.homework

class Table(material: String, weight: Double) : Furniture(material, weight) {
    fun getWeight1(): Double {
        return weight
    }
}