package com.pavel.likholap.lesson18.homework

object Colors {
    const val RESET = "\u001B[0m"
    const val BLACK = "\u001B[30m"
    const val RED = "\u001B[31m"
    const val GREEN = "\u001B[32m"
    const val YELLOW = "\u001B[33m"
    const val BLUE = "\u001B[34m"
    const val PURPLE = "\u001B[35m"
    const val CYAN = "\u001B[36m"
    const val WHITE = "\u001B[37m"
}

object Background {
    const val RESET = "\u001B[0m"
    const val BLACK = "\u001B[40m"
    const val RED = "\u001B[41m"
    const val GREEN = "\u001B[42m"
    const val YELLOW = "\u001B[43m"
    const val BLUE = "\u001B[44m"
    const val PURPLE = "\u001B[45m"
    const val CYAN = "\u001B[46m"
    const val WHITE = "\u001B[47m"
}
fun main(){
    for (animal in listOf(Cat("Cat"), Dog("Dog"), Bird("Bird"))){
        animal.makeSound()
    }

    for (figure in listOf(Circle(32.0), Square(23.0, 78.98), Triangle(12.56, 4.59))){
         println(figure.area())
    }

    LaserPrinter().printString("Hello guys whats up")
    InkjetPrinter().printString("Hello guys whats up Hello guys whats up Hello guys whats up Hello " +
            "guys whats up Hello guys whats up Hello guys whats up Hello guys whats up Hello guys whats up " +
            "Hello guys whats up Hello guys whats up Hello guys whats up Hello guys whats up Hello guys whats " +
            "up Hello guys whats up Hello guys whats up ")


    val shoppCart = ShoppingCart()
    shoppCart.addToCart(1)
    shoppCart.addToCart(1, 8)
    shoppCart.addToCart(listOf(1, 2, 3, 5))
    shoppCart.addToCart(mapOf(1 to 2, 3 to 5, 12 to 90))
    println(shoppCart.toString())

    val logger = Logger()
    logger.log("Start apply backup plan")
    logger.log("WARNING", "Recovery was canceled by timeOut")
    logger.log("ERROR", "Backup is failed")
    logger.log(listOf("Message1", "Message2", "Message3"))
    logger.log(Exception("Can not open specified backup archive"))

}