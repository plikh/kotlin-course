package com.pavel.likholap.lesson17.homework

//Второй класс должен получать список строк и вставлять их в начало контейнера но поочерёдно с
//теми данными, которые уже есть. То-есть, наш список должен появиться в контейнере по индексам 0, 2, 4 и так далее.

class Second: Materials(){
    fun addByStep(newMaterials: MutableList<String>){
        val materials = extractMaterial().toMutableList()
        for (i in materials.indices.filter { it % 2 == 0 }){
            if (newMaterials.isNotEmpty()) {materials.add(i, newMaterials.removeAt(0))}
        }
        materials.forEach {addMaterial(it)}
    }

}