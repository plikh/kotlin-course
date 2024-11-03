package com.pavel.likholap.lesson17.homework

//Четвёртый класс должен принимать словарь из строк (ключи и значения).
//Каждая пара ключа и значения должна попадать в контейнер следующим образом - ключ в начало, значение в конец.

class Fourth: Materials(){
    fun addEntry(newMaterials: Map<String, String>){
        val m = extractMaterial().toMutableList()
        newMaterials.forEach {m.add(0, it.key)
            m.add(it.value)}
        m.forEach { addMaterial(it) }
    }
}
