package com.pavel.likholap.lesson18.homework

class InkjetPrinter: Printer() {
    private fun getTextAttributes(): Pair<String, String>{
        val colorList = listOf(Colors.BLACK, Colors.RED, Colors.GREEN, Colors.YELLOW,
            Colors.BLUE, Colors.PURPLE, Colors.CYAN, Colors.WHITE)
        val backGroundList = listOf(Background.BLACK, Background.RED, Background.GREEN, Background.YELLOW,
            Background.BLUE, Background.PURPLE, Background.CYAN, Background.WHITE)
        val color = colorList.random()
        val backGround = backGroundList.random()
        return Pair(color, backGround)
    }

    override fun printString(str: String) {
        for (word in splitString(str)){
            val textAttribute = getTextAttributes()
            println("${textAttribute.first}${textAttribute.second}$word${Colors.RESET}")
        }

    }
}