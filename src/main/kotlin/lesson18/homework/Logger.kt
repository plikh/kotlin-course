package com.pavel.likholap.lesson18.homework

class Logger {
    fun log(message: String){
        println("INFO: $message")
    }

    fun log(levelLog: String, message: String){
        when (levelLog){
            "WARNING" -> println("${Colors.YELLOW}$levelLog: $message${Colors.RESET}")
            "ERROR" -> println("${Colors.WHITE}${Background.RED}$levelLog: $message${Colors.RESET}")

        }
    }

    fun log(messages:List<String>){
        messages.forEach { println("INFO: $it") }
    }

    fun log(exception:Exception){
        println("ERROR: $exception.message")
    }

}