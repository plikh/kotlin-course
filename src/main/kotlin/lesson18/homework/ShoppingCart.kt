package com.pavel.likholap.lesson18.homework

class ShoppingCart {
    private val cartItems = mutableMapOf<Int, Int>()

    fun addToCart(itemId: Int){
        cartItems[itemId] = cartItems.getOrDefault(itemId, 0) + 1
    }

    fun addToCart(itemId: Int, amount: Int){
        cartItems[itemId] = cartItems.getOrDefault(itemId, 0) + amount
    }

    fun addToCart(mapItems: Map<Int, Int>){
        mapItems.forEach {cartItems[it.key] = cartItems.getOrDefault(it.key, 0) + it.value}
    }

    fun addToCart(itemsId: List<Int>){
        itemsId.forEach {cartItems[it] = cartItems.getOrDefault(it, 0) + 1}
    }

    override fun toString(): String {
        var result = ""
        for (item in cartItems){
            result += "itemID: ${item.key}; Item Count: ${item.value}\n"
        }
        result += "Common unique items id's count: ${cartItems.keys.size}\n"
        result += "Common items count: ${cartItems.values.sum()}"
        return result
    }
}