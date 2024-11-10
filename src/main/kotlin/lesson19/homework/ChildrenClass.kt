package com.pavel.likholap.lesson19.homework

class ChildrenClass(
    val privateVal: String,
    protectedVal: String,
    // объясни, почему этот аргумент доступен в main() несмотря на то, что это не поле
    // этот публичный аттрибут доступен из родительского класса
    publicVal: String
) : BaseClass(privateVal, protectedVal, privateVal) {

    // объясни, почему в main() доступна функция getAll() хотя её здесь нет
    // этот публичный метод, он доступен из родительского класса


    // проверь, что выводится на печать при вызове функции printText()
    // и объясни, почему не происходит переопределение метода privatePrint()
    // printText() печатает "Печать из класса BaseClass" тк на уровне BaseClass privatePrint()
    // определен как приватный метод
    private fun privatePrint() {
        println("Печать из класса ChildrenClass")
    }
    override fun verifyPublicField(value: String): Boolean {
        return true
    }

    fun updateProtectedVar(newValue: String) {
        protectedField = newValue
    }


}

fun main(){
    val a = ChildrenClass("PrivVal", "ProtVal", "PubVal")
    a.publicField = "Антонио Бандерас"
    a.updateProtectedVar("Changed protectedField")
    a.updatePrivateField("Changed privateField")
    println(a.getAll())
}