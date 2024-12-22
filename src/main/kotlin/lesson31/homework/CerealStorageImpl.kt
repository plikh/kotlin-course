package com.pavel.likholap.lesson31.homework

class CerealStorageImpl(
    override val containerCapacity: Float,
    override val storageCapacity: Float
) : CerealStorage {
    init {
        require(containerCapacity > 0) {
            "Capacity container must be more than zero"
        }
        require(storageCapacity >= containerCapacity) {
            "Storage capacity must not be less than capacity of container"
        }
    }

    private val storage = mutableMapOf<Cereal, Float>()

    override fun addCereal(cereal: Cereal, amount: Float): Float {
        require(amount >= 0) { "Amount can not be negative" }

        val currentAmount = storage.getOrDefault(cereal, 0f)
        if (currentAmount == containerCapacity) {
            throw IllegalStateException("No space in container")
        }

        val totalAmount = currentAmount + amount
        val leftover = if (totalAmount > containerCapacity) totalAmount - containerCapacity else 0f
        storage[cereal] = if (totalAmount > containerCapacity) containerCapacity else totalAmount

        return if (leftover > 0) leftover else totalAmount
    }

    override fun getCereal(cereal: Cereal, amount: Float): Float {
        require(amount > 0) { "Amount can not be negative or zero" }

        val currentAmount = storage.getOrDefault(cereal, 0f)
        val retrieved = if (amount > currentAmount) currentAmount else amount
        storage[cereal] = currentAmount - retrieved

        return retrieved
    }

    override fun removeContainer(cereal: Cereal): Boolean {
        val currentAmount = storage.getOrDefault(cereal, 0f)
        if (currentAmount > 0) return false
        storage.remove(cereal)
        return true
    }

    override fun getAmount(cereal: Cereal): Float {
        return storage.getOrDefault(cereal, 0f)
    }

    override fun getSpace(cereal: Cereal): Float {
        val currentAmount = storage.getOrDefault(cereal, 0f)
        return containerCapacity - currentAmount
    }

    override fun toString(): String {
        val cereals = storage.entries.joinToString(", ") {
            "${it.key} = ${it.value}"
        }
        return """
            Container capacity: $containerCapacity;
            Storage Capacity: $storageCapacity;
            Cereals: $cereals
        """.trimIndent()
    }

}