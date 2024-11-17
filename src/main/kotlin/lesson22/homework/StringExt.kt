package com.pavel.likholap.lesson22.homework

/*
Реализуйте для класса String два метода расширения: encrypt и decrypt.
Метод encrypt должен сдвигать каждый символ исходной строки на заданное число позиций вперед по таблице
Unicode, а метод decrypt — на то же число позиций назад. Оба метода принимают один параметр base типа Int,
 который определяет величину сдвига. Протестируйте вашу реализацию, убедившись, что после шифрования и
 последующей расшифровки строка возвращается к исходному состоянию.
Сдвиг по таблице Unicode реализуется простым прибавлением или вычитанием размера сдвига к char символу.
 */

fun String.encrypt(base: Int): String {
    return this.map { (it.code + base).toChar() }.
    joinToString("")
}

fun String.decrypt(base: Int): String {
    return this.map { (it.code - base).toChar() }.
    joinToString("")
}

/*
Многие уже знают любимую игру в Твиттере - собирание разных слов из
букв через ответы (но мы то знаем что слово только одно, но не будем его называть).
Напиши метод расширения строки, который будет принимать список имён пользователей и
выводить в консоли эту строку побуквенно в столбик: имя автора и букву под ним.
Если сможешь повторить оригинальный шаблон вывода ответов с помощью похожих ASCII символов,
будет очень круто. Вот ссылка на референс:
https://x.com/SadNSober_/status/1370280031616897026
 */

fun String.getNameAndLetter(lst: List<String>){
    if (lst.size < 6) throw Exception("Not enough names in list")
    val mainL = if (lst.size > 6) lst.take(6) else lst
    val hit = "Hitler"
    lst.forEach { println(it)
    println(hit[mainL.indexOf(it)])
    }
}