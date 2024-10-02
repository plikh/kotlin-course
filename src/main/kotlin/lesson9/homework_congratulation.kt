package com.pavel.likholap.lesson9

import java.util.Base64

const val MAIN_TEXT = "To check message"

fun main(){
    println(printCongratulation(arrayOf(0, 1, 2, 3).random()))
}

fun printCongratulation(i: Int): String{
    return when (i){
        0 -> getInChinese()
        1 -> getEncrypted()
        2 -> getEncoded()
        else -> "Happy Birthday!!!"
    }
}

fun getInChinese(): String{
    return "$MAIN_TEXT, put that row: 老师生日快乐!! to google translator)"
}

fun getEncrypted(): String{
    return "$MAIN_TEXT, use decrypt function with 'aHppy iBtrdhya!' argument"
}

fun getEncoded(): String{
    return """$MAIN_TEXT, use decode function with 'SGFwcHkgQmlydGhkYXkh'
argument but better use https://www.base64decode.org
because we haven't learned decoding yet)))""".trimIndent()
}


fun decrypt(str: String): String{
    val result:  MutableList<String> = mutableListOf()
    for (i in str.split(" ")){
        val stringToEncrypt = if (i.length % 2 != 0) "$i " else i
        var resultWord = ""
        for (j in stringToEncrypt.indices step 2){resultWord += "${stringToEncrypt[j + 1]}${stringToEncrypt[j]}"}
        result.add(resultWord.replace(" ", "")) }
    return result.joinToString(" ")
}

fun decode(str: String): String{
    return String(Base64.getDecoder().decode(str))
}