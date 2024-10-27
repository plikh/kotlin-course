package com.pavel.likholap.lesson15.homework

class Rack(private val rackCapacity: Int){
    private val shelves = mutableListOf<Shelf>()

    private fun checkCapacity(): Boolean{
        return shelves.size + 1 > rackCapacity
    }

    private fun checkContain(shelf: Shelf): Boolean{
        return shelves.contains(shelf)
    }

    private fun checkShelf(shelf: Shelf): Boolean{
        return !(checkContain(shelf) || checkCapacity())
    }

    fun addShelf(shelf: Shelf): Boolean{
        val result = checkShelf(shelf)
        if (result){
            shelves.add(shelf)
        }
        return result
    }

    fun removeShelf(shelfIndex: Int): Boolean{
        val result = shelfIndex in shelves.indices
        if (result){
            shelves.removeAt(shelfIndex)
        }
        return result
    }

    private fun getFreeShelf(name: String): Shelf?{
        val res = shelves.map {it to it.shelfCapacity - it.items.joinToString("").length}.maxBy { it.second }
        return if (name.length <= res.second) res.first else null
    }

    private fun addItem(name: String): Boolean{
        val res = getFreeShelf(name) ?: return false
        res.addItem(name)
        return true
    }

    fun removeItem(name: String): Boolean{
        return shelves.any { it.removeItem(name) }
    }

    fun checkItemShelf(name: String): Boolean{
        return shelves.any {it.checkItem(name)}
    }

    fun getShelvesList(): List<Shelf>{
        return shelves.toList()
    }

    fun printContents(){
        for (s in shelves){
            println(""""index: ${shelves.indexOf(s)}
                    shelf_capacity: ${s.shelfCapacity}
                    available_space: ${s.shelfCapacity - s.items.joinToString("").length}
                    items: ${s.items}""".trimMargin())
        }
    }

    fun advancedRemoveShelf(index: Int): List<String> {
        val unallocatedItems = mutableListOf<String>()
        if (index >= shelves.size) return unallocatedItems
        val removedShelf = shelves.removeAt(index)
        for (item in removedShelf.getItems().sortedByDescending { it.length }) {
            if (addItem(item)) continue
            unallocatedItems.add(item)
        }
        return unallocatedItems
    }

}