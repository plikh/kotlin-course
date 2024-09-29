package com.pavel.likholap.lesson8


fun main(){
    printMultiplicationTable()
    print(formatToCapitalize("hello. world, what's up"))
    println(formatToCapitalize("!@#$, ;"))
    println(encrypt("some_string"))
    println(decrypt("osems_rtnig"))
    println(convert("Это невозможно выполнить за один день"))
    println(convert("Я не уверен в успехе этого проекта"))
    println(convert("Произошла катастрофа на сервере"))
    println(convert("Этот код работает без проблем"))
    println(convert("Удача"))
    getLogDateTime("Пользователь вошел в систему -> 2021-12-01 09:48:23")
    println(maskCardData("4539 1488 0343 6467"))
    println(formatEmailAddress("name.surname@gmail.com"))
    println(getFileName("C:/Пользователи/Документы/report.txt"))
    println(getAbbreviation("Объектно-ориентированное программирование"))

}



/*
Создайте функцию, которая будет анализировать входящие фразы и применять к ним различные преобразования,
делая текст более ироничным или забавным. Функция должна уметь распознавать
ключевые слова или условия и соответственно изменять фразу.
 */

fun convert(s: String): String{
    return when {
        s.contains("невозможно", true) -> s.replace("невозможно",
            "совершенно точно возможно, просто требует времени", true)
        s.startsWith("Я не уверен", true) -> "$s но моя интуиция говорит об обратном"
        s.contains("катастрофа", true) -> s.replace("катастрофа",
            "интересное событие", true)
        s.endsWith("без проблем") -> s.replace("без проблем",
            "с парой интересных вызовов на пути", true)
        !s.contains(" ") -> "Иногда, $s, но не всегда"
        else -> ""
    }
}



//Задание 1: Извлечение Даты из Строки Лога. Используй indexOf или split для получения правой части сообщения.

fun getLogDateTime(logString: String){
    val dateTime = logString.split(" -> ").last().split(" ")
    println(dateTime.first())
    println(dateTime.last())
}

//Задание 2: Маскирование Личных Данных

fun maskCardData(cardData: String): String{
    return "**** **** **** ${cardData.split(" ").last()}"
}

//Задание 3: Форматирование Адреса Электронной Почты

fun formatEmailAddress(emailAddress: String): String{
    val splitEmail = emailAddress.split("@")
    val splitDomain = splitEmail.last().split(".")
    return "${splitEmail.first()} [at] ${splitDomain.first()} [dot] ${splitDomain.last()}}"
}

//Задание 4: Извлечение Имени Файла из Пути

fun getFileName(pathToFile: String): String{
    return pathToFile.split("/").last()
}

/*
Задание 5: Создание Аббревиатуры из Фразы. Используй split с набором символов для разделения.
Используй for для перебора слов. Используй var переменную для накопления первых букв
 */

fun getAbbreviation(str: String): String{
    var result = ""
    for (word in str.split(", ", "-", " ", ". ")){
        if (word.isNotBlank() && word.isNotEmpty()) {
            result += word.first().uppercase()
        }
    }
    return result
}

/*
Написать метод, который преобразует строку из нескольких слов в строку, где каждое слово начинается с заглавной
буквы а все остальные - строчные. (можно использовать такой же подход как в задании 5, но накапливать не первые буквы
а целиком слова, составленные из первой буквы с uppercase и оставшейся части слова)
 */

fun formatToCapitalize(str: String): String{
    var result = ""
    for (word in str.split(", ", "-", " ", ". ")){
        result += if (!word.first().isLetter()){
            word
        } else {
            "${word.first().uppercase()}${word.substring(1)} "
        }
    }
    return result.trim()
}

/*
Написать шифратор/дешифратор для строки. Шифровка производится путём замены двух соседних букв между собой:
Kotlin шифруется в oKltni. Дешифровка выполняется аналогично. Если длина строки - нечётная, в конец добавляется
символ пробела до начала шифрования. Таким образом все шифрованные сообщения будут с чётной длинной.
Должно получиться два публичных метода: encrypt() и decrypt() которые принимают и возвращают строку
 */

fun encrypt(str: String): String{
    var result = ""
    val stringToEncrypt = if (str.length % 2 != 0) "$str " else str
    for (i in stringToEncrypt.indices step 2){

        result += "${stringToEncrypt[i + 1]}${stringToEncrypt[i]}"
    }
    return result.replace(" ", "")
}

fun decrypt(str: String): String{
    var result = ""
    val stringToDecrypt = if (str.length % 2 != 0) "$str " else str
    for (i in stringToDecrypt.indices step 2){

        result += "${stringToDecrypt[i + 1]}${stringToDecrypt[i]}"
    }
    return result.replace(" ", "")
}

//Таблица умножения

fun printMultiplicationTable(start: Int = 1, end: Int = 9){
    if (start <= 0 || end <= 0){
        throw Exception("Wrong argument value")
    }
    val spacesCount: Int = (end * end).toString().length + 1
    for (i in start..end) {
        if (i == start){print("".padStart(spacesCount))}
        print(i.toString().padStart(spacesCount))
    }
    println()

    for (i in start..end){
        print(i.toString().padStart(spacesCount))
        for (j in start..end){
            val result = i * j
            print(result.toString().padStart(spacesCount))
        }
        println()
    }
}
