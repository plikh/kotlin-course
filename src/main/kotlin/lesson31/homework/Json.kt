package com.pavel.likholap.lesson31.homework

import com.google.gson.GsonBuilder
import java.io.File


/*
Создай дата класс сотрудника компании Employee, содержащий:
имя
статус трудоустройства (булево)
дата рождения (строка)
должность CharacterTypes (enum из прошлого урока)
список подчинённых с типом Emploee
Создай небольшую иерархию из сотрудников где во главе CTO. Это значит что в объект сотрудника
с должностью CTO в поле списка подчинённых должны попасть пара тим лидов, в списке подчинённых которых
есть разработчики, дизайнеры и тестировщики. Чтобы было немного но и была вложенность.
Сериализуй CTO в текст с настройкой prettyPrinting и текст запиши в файл в корне проекта.
Прочитай текст из файла, десериализуй его в объект класса Employee и распечатай в консоль.
 */

data class Employee(
    val name: String,
    val hasJob: Boolean,
    val dateOfBirth: String,
    val position: CharacterTypes,
    val listOfEmployee: List<Employee>?
)


enum class CharacterTypes {
    CTO,
    LEAD,
    DEVELOPER,
    QA,
    DESIGNER,
    ;
}


fun main() {
    val qa = Employee(
        "Pavel Pavlov", true, "30.06.1989",
        CharacterTypes.QA, null
    )
    val dev = Employee(
        "Dmitry Dmitriev", true, "12.12.1979",
        CharacterTypes.DEVELOPER, null
    )
    val des = Employee(
        "Oleg Olegov", true, "11.11.1993",
        CharacterTypes.DESIGNER, null
    )
    val lead1 = Employee(
        "Petr Petrov", true, "09.05.1982",
        CharacterTypes.LEAD, listOf(qa, des, dev)
    )
    val lead2 = Employee(
        "Igor Igorev", true, "24.09.1992",
        CharacterTypes.LEAD, listOf(qa, des, dev)
    )
    val cto = Employee(
        "Ivan Ivanov", true, "23.01.1968",
        CharacterTypes.CTO, listOf(lead1, lead2)
    )

    val gson = GsonBuilder()
        .setPrettyPrinting()
        .serializeNulls()
        .create()

    val jsCto = gson.toJson(cto)
    val file = File("cto.json")
    file.createNewFile()
    file.writeText(jsCto)

    println(gson.fromJson(file.readText(), Employee::class.java))


}
