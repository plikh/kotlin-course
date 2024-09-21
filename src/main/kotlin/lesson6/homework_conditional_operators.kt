package com.pavel.likholap.lesson6


fun main(){

    println(getYearSeason(9))
    println(getYearSeason(34))

    println(getCalculatedPetAge(1.0))
    println(getCalculatedPetAge(11.0))

    println(getTransport(0.034))
    println(getTransport(3.7))
    println(getTransport(345.09))
    println(getTransport(0.0))

    println(getCalculateBonuses(16782.0))
    println(getCalculateBonuses(99.0))
    println(getCalculateBonuses(120.0))
    println(getCalculateBonuses(-1.0))

    println(getDocumentType("qwerty"))
    println(getDocumentType("docx"))
    println(getDocumentType("json"))
    println(getDocumentType("png"))

    println(getConvertedTemperature(20.0, 'F'))
    println(getConvertedTemperature(59.0, 'C'))

    println(selectClothes(40))
    println(selectClothes(-31))
    println(selectClothes(-29))
    println(selectClothes(1))
    println(selectClothes(19))


    println(getMovieByAge(5))
    println(getMovieByAge(12))
    println(getMovieByAge(17))
    println(getMovieByAge(18))
    println(getMovieByAge(0))

}

/*
Задание 1: "Определение Сезона"
Контекст: Напишите функцию, которая на основе номера месяца возвращает сезон года.
 */

fun getYearSeason(monthNumber: Int): String {
    if (monthNumber !in 1..12) {
        throw Exception("Некорректный номер месяца")
    } else {
        val season: String = when (monthNumber) {
            in 3..5 -> "Весна"
            in 6..8 -> "Лето"
            in 9..11 -> "Осень"
            else -> "Зима"
        }
        return season
    }
}


/*
Задание 2: "Расчет Возраста Питомца"
Контекст: Создайте функцию, которая преобразует возраст собаки в "человеческие" годы.
До 2 лет каждый год собаки равен 10.5 человеческим годам, после - каждый год равен 4 человеческим годам.
 */

fun getCalculatedPetAge(petAge: Double): Double{
    val calculatedPetAge: Double = if (petAge in 0.0..2.0) {petAge * 10.5} else {(petAge - 2) * 4 + 2 * 10.5}
    return calculatedPetAge
}

/*
Задание 3: "Определение Вида Транспорта"
Контекст: Напишите функцию, которая определяет,
какой вид транспорта лучше использовать, исходя из длины маршрута.
Если маршрут до 1 км - "пешком", до 5 км - "велосипед", иначе - "автотранспорт".
 */

fun getTransport(distance: Double): String{
    if (distance <= 0) {throw Exception("Дистанция маршрута должна быть больше нуля")} else {
        val transport: String = when {
            distance <= 1 -> "пешком"
            distance in 1.0..5.0 -> "велосипед"
            else -> "автотранспорт"
        }
        return transport
    }
}

/*
Задание 4: "Расчет Бонусных Баллов"
Контекст: Клиенты интернет-магазина получают бонусные баллы за покупки.
Напишите функцию, которая принимает сумму покупки и возвращает количество
бонусных баллов: 2 балла за каждые 100 рублей при сумме покупки до 1000 рублей
и 5 баллов за каждые 100 рублей при сумме свыше этого.
 */
fun getCalculateBonuses(purchaseSum: Double): Double {
    if (purchaseSum <= 0) {throw Exception("Сумма покупки должна быть больше нуля")} else {
        val calculatedBonuses: Double = when {
        purchaseSum > 1000.0 -> (purchaseSum / 100) * 5
        purchaseSum in 100.0..1000.0 -> (purchaseSum / 100) * 2
        else -> 0.0
        }
        return calculatedBonuses
    }
}

/*
Задание 5: "Определение Типа Документа"
Контекст: В системе хранения документов каждый файл имеет расширение.
Напишите функцию, которая на основе расширения файла возвращает его тип:
"Текстовый документ", "Изображение", "Таблица" или "Неизвестный тип".
*/

fun getDocumentType(extension: String): String{
    return when (extension){
        in listOf("txt", "docx", "pdf") -> "Текстовый документ"
        in listOf("jpg", "png", "gif") -> "Изображение"
        in listOf("xls", "csv", "json") -> "Таблица"
        else -> "Неизвестный тип"
    }
}

/*
Задание 6: "Конвертация Температуры"
Контекст: Создайте функцию, которая конвертирует температуру из градусов Цельсия в Фаренгейты и наоборот
в зависимости от указанной единицы измерения (C/F). Единицу измерения нужно передать вторым аргументом функции.
Несколько аргументов передаются через запятую. Возвращать нужно строку.
Подсказка: для генерации строки из числа и буквы можно использовать шалон “$result F” для фаренгейта или “$result C” для цельсия
*/

fun getConvertedTemperature(temperature: Double, unit: Char): String{
    val convertedTemperature = if (unit == 'F') {(temperature * 1.8) + 32.0} else {(temperature - 32.0)/1.8}
    return "$convertedTemperature $unit"
}

/*
Задание 7: "Подбор Одежды по Погоде"
Контекст: Напишите функцию, которая на основе температуры
воздуха рекомендует тип одежды: "куртка и шапка" при температуре ниже 0,
"ветровка" от 0 до 15 градусов и "футболка и шорты" при температуре выше 15.
При температурах ниже -30 и выше +35 рекомендуйте не выходить из дома.
 */

fun selectClothes(temperature: Int): String{
    return when {
        temperature > 35 || temperature < -30 -> "опасно выходить из дома"
        temperature in -1 downTo -30 -> "куртка и шапка"
        temperature in 0 ..15 -> "ветровка"
        temperature > 15 -> "футболка и шорты"
        else -> ""
    }
}

/*
Задание 8: "Выбор Фильма по Возрасту"
Контекст: Кинотеатр предлагает фильмы разных возрастных категорий. Напишите функцию,
которая принимает возраст зрителя и возвращает доступные для него категории фильмов: "детские", "подростковые", "18+".
 */


fun getMovieByAge(age: Int): String{
    if (age <= 0) {
        throw Exception("Некорректное значение возраста")} else
    return when {
        age in 5..10 -> "детские"
        age in 5 until 18 -> "подростковые"
        age >= 18 -> "18+"
        else -> "Вход запрещен"
    }
}
