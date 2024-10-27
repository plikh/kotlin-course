package com.pavel.likholap.lesson15.homework

class Shelf(val shelfCapacity: Int){
    val items = mutableListOf<String>()

    private fun canAccommodate(name: String): Boolean{
        return items.joinToString("").length + name.length <= shelfCapacity
    }

    fun checkItem(name: String): Boolean{
        return items.contains(name)
    }

    fun addItem(name: String): Boolean{
        return canAccommodate(name) && items.add(name)
    }

    fun removeItem(name: String): Boolean {
        return items.remove(name)
    }

    fun getItems(): List<String>{
        return items.toList()
    }
}