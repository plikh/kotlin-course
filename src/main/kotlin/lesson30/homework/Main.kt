package com.pavel.likholap.lesson30.homework

/*
Задание 1
Создай Enum со статусами прохождения теста (pass, broken, failure).
Создай Enum с типами жилой недвижимости для сайта аренды, включая человекопонятные названия этих типов.
Создай Enum с планетами солнечной системы, включая расстояние до солнца в астрономических единицах и вес планеты.
*/

enum class TestStatuses {
    PASS,
    BROKEN,
    FAILURE,
    ;
}

enum class Apartment(val displayName: String) {
    HOUSE("house"),
    FLAT("flat"),
    OFFICE("office"),
    ;
}

enum class Planet(val distanceToSun: Double, val mas: Double) {
    MERCURY(0.4, 3.3e23),
    VENUS(0.7, 4.87e24),
    EARTH(1.0, 5.97e24),
    MARS(1.5, 6.42e23),
    JUPITER(5.2, 1.90e27),
    SATURN(9.5, 5.68e26),
    URANUS(19.2, 8.68e25),
    NEPTUNE(30.1, 1.02e26),
    ;
}

//Задание 2
//Создай функцию, которая выводит на печать человекочитаемые
//названия типов недвижимости в порядке возрастания длины названия enum.

fun printApartName() {
    Apartment.entries.sortedBy { it.name.length }.forEach { println(it.displayName) }
}

//Задание 3
//Создай функцию, которая принимает лямбду без аргументов и возвращаемого значения и возвращает Enum со статусом
//прохождения теста в зависимости от того как выполнится принятая лямбда. Если без исключений - pass,
//если будет AssertionError - failure, прочие исключения  - broken.


fun getTestResult(test: () -> Unit): TestStatuses {
    try {
        test()
    } catch (e: AssertionError) {
        return TestStatuses.FAILURE
    } catch (e: Exception) {
        return TestStatuses.BROKEN
    }
    return TestStatuses.PASS

}


//Задание 4
//Создай функцию, которая принимает лямбду и возвращает enum планеты. Лямбда должна принимать планету и возвращать
// булево значение. Лямбда здесь выступает в качестве фильтра, который должен отфильтровать список всех планет по
// какому-либо признаку (расстояние или вес). Вернуть нужно первый элемент из отфильтрованного списка или выкинуть
//исключение если список пустой.
fun getPlanets(conditions: (Planet) -> Boolean): Planet {
    return Planet.entries.firstOrNull(conditions)
        ?: throw Exception("The Planet enum does not contain planet with specified condition")
}


/*
Дополнительное задание 1 Светофор
Создай enum с перечислением для светофора. Enum должен включать цвет из класса Colors,
длительность сигнала duration и количество миганий blinkTimes (может быть null).
Мигание нужно установить только для зелёного сигнала.
Реализовать функцию с бесконечным циклом, которая будет выводить сигналы светофора в порядке:
красный (4 сек), жёлтый (2 сек), зелёный (4 сек), зелёный мигающий (4 раза).
Отображение сигнала выполняется через showSignal()
Задержку между сигналами можно выполнить через Thread.sleep() в который передаётся задержка в миллисекундах.
Мигание выполняется через попеременный вызов clear() и showSignal() с задержками между ними в 300мс
 */
enum class Colors(val value: String) {
    RED_COLOR("\u001B[31m"),
    YELLOW_COLOR("\u001B[33m"),
    GREEN_COLOR("\u001B[32m"),
    RESET_COLOR("\u001B[0m")
}

const val LIGHT_SYMBOL = "\u25CF"
fun showSignal(signal: TrafficLightSignal) {
    print("\r" + signal.color.value + LIGHT_SYMBOL + Colors.RESET_COLOR.value)
}

fun clear() {
    print("\r    ")
}

enum class TrafficLightSignal(val color: Colors, val duration: Long, val blinkTimes: Int?) {
    RED(Colors.RED_COLOR, 4000, null),
    YELLOW(Colors.YELLOW_COLOR, 2000, null),
    GREEN(Colors.GREEN_COLOR, 4000, null),
    GREEN_BLINKING(Colors.GREEN_COLOR, 300, 4);
}

fun trafficLightCycle() {
    while (true) {
        for (signal in TrafficLightSignal.entries) {
            if (signal.blinkTimes == null) {
                showSignal(signal)
                Thread.sleep(signal.duration)
            } else {
                repeat(signal.blinkTimes) {
                    showSignal(signal)
                    Thread.sleep(signal.duration)
                    clear()
                    Thread.sleep(signal.duration)
                }
            }
        }
    }
}


/*
Дополнительное задание 2
Напиши функцию, которая определит, какой тип кофе предложить посетителю исходя из его функциональной принадлежности.
Эспрессо - СТО или тимлид
Латте - дизы и геймдев
Капучино - Менеджеры
Американо - бэкендеры и сисадмины
Для QA добавь в enum ещё один вид напитка: Nescafe classic
Реши задачу через доработку enum CharacterTypes
 */

enum class CoffeeType(val cost: Double, val coffeeBase: String, val recommendedSugar: Int, val hasMilk: Boolean = false) {
    ESPRESSO(2.50, "Espresso", 0),
    LATTE(3.00, "Latte", 2, true),
    CAPPUCCINO(2.75, "Cappuccino", 1, true),
    AMERICANO(2.25, "Americano", 0),
    NESCAFE_CLASSIC(3.89, "Double Espresso", 0);

    fun description() = "The $coffeeBase ${if (hasMilk) "with" else "without"} " +
            "milk costs \$$cost and is best with $recommendedSugar spoons of sugar."
}



enum class CharacterTypes(val recommendedCoffee: CoffeeType) {
    CTO(CoffeeType.ESPRESSO),
    TEAM_LEAD(CoffeeType.ESPRESSO),
    UX_UI(CoffeeType.LATTE),
    GAME_DEV(CoffeeType.LATTE),
    CRM(CoffeeType.CAPPUCCINO),
    PM(CoffeeType.CAPPUCCINO),
    BACKEND_DEV(CoffeeType.AMERICANO),
    SYSADMIN(CoffeeType.AMERICANO),
    QA(CoffeeType.NESCAFE_CLASSIC);
}

fun suggestCoffeeForCharacter(characterType: CharacterTypes): CoffeeType {
    return characterType.recommendedCoffee
}