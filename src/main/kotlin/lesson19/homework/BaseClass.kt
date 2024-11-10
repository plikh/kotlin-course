package com.pavel.likholap.lesson19.homework

abstract class BaseClass(
    // объясни, почему это поле доступно в main() для чтения из класса ChildrenClass
    // в ChildrenClass privateVal не приватный атрибут, соответственно мы имеем доступ к нему вне класса
    private val privateVal: String,
    // объясни, почему это поле недоступно в main()
    // protected аттрибуты и методы доступны только для класса и внутри дочерных классов
    protected val protectedVal: String,
    val publicVal: String
) {

    var publicField = "измени меня из функции main() на Антонио Бандераса и проверь через функцию getAll()" +
            "Доработай ChildrenClass таким образом, чтобы это получилось"
        set(value) {
            if (verifyPublicField(value)) {
                field = value
            }
        }
    protected var protectedField = "измени меня из функции main() через сеттер в наследнике"
    private var privateField = "добавь сеттер чтобы изменить меня из main()"

    fun updatePrivateField(newValue: String){
        privateField = newValue
    }



    fun getAll(): String {
        return mapOf(
            "privateVal" to privateVal,
            "protectedVal" to protectedVal,
            "publicVal" to publicVal,
            "publicField" to publicField,
            "protectedField" to protectedField,
            "privateField" to privateField,
        ).map { "${it.key}: ${it.value}" }
            .joinToString("\n")
    }

    fun printText() {
        privatePrint()
    }

    // объясни, почему эта функция не может быть публичной
    // тк класс ProtectedClass доступен только из текущего класса и дочерних классов
    protected open fun getProtectedClass() = ProtectedClass()

    protected open fun verifyPublicField(value: String): Boolean {
        return value.length < 3
    }

    private fun privatePrint() {
        println("Печать из класса BaseClass")
    }

    // объясни, почему эта функция не может быть публичной или protected
    // тк класс PrivateClass доступен только из текущего класса
    private fun getPrivateClass() = PrivateClass()

    protected class ProtectedClass

    private class PrivateClass
}
