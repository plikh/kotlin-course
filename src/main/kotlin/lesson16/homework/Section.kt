package com.pavel.likholap.lesson16.homework

val conversionFactors = mapOf(
    ItemType.LIQUIDS to 0.95,
    ItemType.ALCOHOL to 0.8,
    ItemType.FRUIT to 0.65,
    ItemType.VEGETABLE to 0.55
)


class Section(
    val type: String,
    val capacity: Int
) {
    val items = mutableListOf<Item>()

    fun addItem(item: Item): Boolean {
        val itemVolume = convertWeightToVolume(item)
        if (getFreeSpace() >= itemVolume) {
            items.add(item)
            return true
        }
        return false
    }

    fun findItemByName(name: String): Item {
        return items.filter { it.name == name }.first()
    }

    fun remove(item: Item): Boolean {
        return items.remove(item)
    }

    fun getFreeSpace(): Int {
        val usedSpace = items.sumOf { convertWeightToVolume(it) }
        return capacity - usedSpace
    }

    private fun convertWeightToVolume(item: Item): Int {
        return (item.weight / conversionFactors.getValue(item.type)).toInt()
    }

    fun formatData(): String {
        return """
        type: $type
        capacity: $capacity
        free: ${getFreeSpace()}
        items:b${items.joinToString("; ")}
        """.trimIndent()
    }
}