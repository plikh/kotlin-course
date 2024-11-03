package com.pavel.likholap.lesson17.homework

open class Chair(material: String, weight: Double) : Furniture(material, weight) {
    fun getMaterial1(): String {
        return "This is a $material chair"
    }
}