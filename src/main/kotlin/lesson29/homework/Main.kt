package com.pavel.likholap.lesson29.homework


import java.time.*
import java.time.format.DateTimeFormatter
import java.time.temporal.ChronoField
import java.time.temporal.Temporal

private val boomerStart = LocalDate.of(1945, 12, 31)
private val boomerEnd = LocalDate.of(1965, 1, 1)
private val zoomerStart = LocalDate.of(1996, 12, 31)
private val zoomerEnd = LocalDate.of(2013, 1, 1)

fun main() {
//Создай текущую временнУю метку и выведи её на печать (чтобы ещё раз запомнить название этого класса)

    val currentTime = Instant.now()
    println(currentTime)


//Создай дату своего дня рождения.

    val birthDay = LocalDate.of(1989, 6, 30)
    println(birthDay)


//Создай период между датой своего рождения и текущей датой. Выведи на печать количество лет из этого периода.

    val period = Period.between(birthDay, LocalDate.now()).years
    println(period)


//Создай функцию, которая принимает тип Temporal и выводит форматированное значение в
//зависимости от того, содержит ли аргумент время и часовой пояс. Temporal - это общий тип для разных классов
// даты-времени. В форматированном значении нужно выводить часы, минуты, секунды и таймзону,
// если они представлены в переданном объекте. Обработай в методе все типы дат, которые знаешь.
// Реализуй два варианта функции - с собственный форматированием и с форматами из ISO коллекции.

    val temporalFun: (obj: Temporal, iso: Boolean) -> String = { obj, iso ->
        try {

            if (!iso) {
                when {
                    obj.isSupported(ChronoField.OFFSET_SECONDS) ->
                        DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss z").format(obj)

                    obj.isSupported(ChronoField.HOUR_OF_DAY) ->
                        DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss").format(obj)

                    else -> DateTimeFormatter.ofPattern("yyyy-MM-dd").format(obj)
                }
            } else {
                when {
                    obj.isSupported(ChronoField.OFFSET_SECONDS) -> DateTimeFormatter.ISO_OFFSET_DATE_TIME.format(obj)

                    obj.isSupported(ChronoField.HOUR_OF_DAY) -> DateTimeFormatter.ISO_LOCAL_DATE_TIME.format(obj)

                    else -> DateTimeFormatter.ISO_DATE.format(obj)
                }
            }
        } catch (error: Exception) {
            "Error: You used unsupported 'Temporal' type"
        }
    }

//Создай объекты дат и / или времени которые мы изучили и по очереди передай их в метод созданный выше.
// Не используй в них метод now()

    val d = LocalDate.of(1999, 12, 14)
    val dt = LocalDateTime.of(2000, 11, 12, 12, 44)
    val dtz = ZonedDateTime.of(dt, ZoneId.of("Europe/Warsaw"))
    val dtzof = OffsetDateTime.of(dt, ZoneOffset.ofHours(3))

    println(temporalFun(d, false))
    println(temporalFun(dt, false))
    println(temporalFun(dtz, false))
    println(temporalFun(dtzof, false))

    println(temporalFun(d, true))
    println(temporalFun(dt, true))
    println(temporalFun(dtz, true))
    println(temporalFun(dtzof, true))

/*
Создайте функцию identifyGeneration, которая принимает дату рождения в формате LocalDate и печатает строку,
определяющую, к какому поколению принадлежит человек: "Бумер" для тех, кто родился с 1946 по 1964 год включительно,
и "Зумер" для тех, кто родился с 1997 по 2012 год включительно. Если дата рождения не попадает ни в один из этих
диапазонов, функция должна возвращать "Не определено". Для сравнения дат используй методы isAfter(otherDate)
и isBefore(otherDate). Объекты с эталонными датами вынеси в приватные поля файла с методом identifyGeneration.
 */


    val identifyGeneration: (date: LocalDate) -> Unit = {
        println(
            when {
                it.isAfter(boomerStart) && it.isBefore(boomerEnd) -> "Бумер"
                it.isAfter(zoomerStart) && it.isBefore(zoomerEnd) -> "Зумер"
                else -> "Не определено"

            }
        )
    }

    identifyGeneration(LocalDate.of(1947, 1,2))

/*
Создай два объекта даты: 25 февраля 2023 года и 25 февраля 2024 года. Создай форматтер,
который форматирует дату в месяц и день. Выведи первую отформатированную дату, прибавив к ней 10 дней.
Выведи вторую отформатированную дату, прибавив к ней 10 дней.
 */

    val firstDate = LocalDate.of(2023, 2, 25)
    println(DateTimeFormatter.ofPattern("yyyy/MM/dd").format(firstDate.plusDays(10)))

    val secondDate = LocalDate.of(2024, 2, 25)
    println(DateTimeFormatter.ofPattern("yyyy/MM/dd").format(secondDate.plusDays(10)))
}
