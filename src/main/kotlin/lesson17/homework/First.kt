package com.pavel.likholap.lesson17.homework

//Первый класс должен вставлять строку на дно контейнера (должно появиться под индексом 0)

class First: Materials(){
    fun addToBottom(material: String){
        val materials = extractMaterial().toMutableList()
        materials.add(0, material)
        materials.forEach {addMaterial(it)}

    }
}
