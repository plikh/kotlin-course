package com.pavel.likholap.lesson16.homework

class Fridge(val capacity: Int) {
    private val sections = mutableListOf<Section>()

    fun addSection(section: Section): Boolean {
        if (sections.size > capacity) {

            return false
        }
        return sections.add(section)
    }

    fun removeSectionsByType(type: String): Boolean {
        val initialSize = sections.size
        sections.removeIf { it.type == type }
        return sections.size < initialSize
    }

    fun removeSectionWithRedistribution(section: Section): List<Item> {
        sections.remove(section)
        return section.items
    }

    fun addItem(item: Item): Boolean {
        val section = sections.filter { it.type == item.type && it.getFreeSpace() >= item.weight }.first()
        return section.addItem(item)
    }

    fun findItemByNameAndType(name: String, type: String): Item {
        return sections.filter { it.type == type }.first().findItemByName(name)
    }

    fun removeItem(item: Item): Boolean {
        val section = sections.filter { it.type == item.type }.first()
        return section.remove(item)
    }

    fun removeAllItemsByName(name: String): Int {
        var removedCount = 0
        for (section in sections) {
            for (i in section.items.indices) {
                if (i >= section.items.size) break
                if (section.items[i].name == name) {
                    section.items.removeAt(i)
                    removedCount++
                    continue
                }
            }
        }
        return removedCount
    }

    fun viewFridge() {
        println(sections.joinToString("\n\n") { it.formatData() })
    }
}
