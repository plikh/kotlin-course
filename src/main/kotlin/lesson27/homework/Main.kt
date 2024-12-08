package com.pavel.likholap.lesson27.homework


/*
Задание 1: Создайте функцию timeTracker, которая принимает другую функцию в качестве аргумента и измеряет время её выполнения.
Функция timeTracker должна возвращать затраченное время в миллисекундах. Для измерения времени используйте
System.currentTimeMillis() до и после выполнения переданной функции.
 */

fun timeTracker(arg: () -> List<Int>): Long {
    val start = System.currentTimeMillis()
    arg()
    val end = System.currentTimeMillis()
    return end - start

}


fun main() {
    val myFunction = {
        val list = List(1000000) { (0..10000).random() }
        list.sorted()
    }
    println(timeTracker(myFunction))

//Задание 2: Создайте объект Employee и используйте apply для инициализации его полей email и department.

    val employee = Employee("Pavel Likholap", 35, "QA")
    employee.apply {
        department = "Sigma"
        email = "${name.replace(" ", ".").lowercase()}.${department.lowercase()}@company.com"
    }
    println(employee.department)
    println(employee.email)

/*Задание 3: Создайте функцию, принимающую объект Person и выводящую информацию об объекте в консоль в красивом,
отформатированном виде. Создайте объект Person и используйте also для печати данных в консоль с
помощью метода который только что создали.
 */

    fun getPersonData(person: Person): String {
        return """
            Information about ${person.name}:
            age: ${person.age}
            email: ${person.email}
        """.trimIndent()
    }

    val person = Person("Pavel Likholap", 35)
        .apply { email = "123@gmail.com" }
        .also {
            println(getPersonData(it))
        }

/*
Задание 4: Создайте объект класса Person. Используйте функцию with,
чтобы создать из этого объекта Employee, указав дополнительно должность.
Возвращаемым значением должен быть новый объект Employee.
*/

    val person1 = Person("Pavel Likholap", 35)
    val employee1 = with(person1) {
        Employee(name, age, "QA")
    }

/*
Задание 5: Создайте объект класса Person. Используйте функцию run, чтобы инициализировать объект Employee,
добавить ему email и department с помощью apply, вернуть инициализированный объект.
*/

    val person2 = Person("Pavel Likholap", 35).run {
        Employee(name, age, "QA").apply {
            email = "123@gmail.com"
            department = "Application Backup"
        }
    }


/*
Задание 6: Создайте функцию, которая принимает объект класса Person?, который может быть null.
В функции используйте функцию let для создания Employee, только если объект Person не null.
В противном случае возвращается null
 */

    fun initEmployee(person: Person?): Employee? {
        return person?.let {
            Employee(it.name, it.age, "QA")

        }
    }

}

