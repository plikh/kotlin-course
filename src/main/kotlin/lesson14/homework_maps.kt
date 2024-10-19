package com.pavel.likholap.lesson14

fun main(){

//Дан словарь с именем и временем выполнения каждого автоматизированного
//теста в секундах. Определите среднее время выполнения теста
    val testsTime = mapOf("OD_backup" to 601, "SP_backup" to 894, "Teams_restore" to 5678)
    println(testsTime.values.average())


//Имеется словарь с метаданными автоматизированных тестов, где ключи — это имена тестовых методов
//а значения - строка с метаданными. Выведите список всех тестовых методов.
    val testsMetadata = mapOf("get_slice" to "metadata_1", "browse_archive" to "metadata_2",
        "delete_vault" to "metadata_3")
    println(testsMetadata.keys)


//В изменяемый словарь с данными о прохождении тестов добавьте новый тест и его результат.
    val testResults = mutableMapOf("mailbox_granular_recovery" to "passed", "search_in_encrypted_archive" to "skipped")
    testResults["backup_archived_team"] = "failed"


//Посчитайте количество успешных тестов в словаре с результатами.
    println(testResults.filterValues { it == "passed" }.size)


//Удалите из изменяемого словаря с баг-трекингом запись о баге, который был исправлен
    val bugs = mutableMapOf("bug_1" to "in_progress", "bug_2" to "resolved", "bug_3" to "open")
    bugs
        .filterValues { it == "resolved" }
        .forEach {bugs.remove(it.key)}


//Для словаря с результатами тестирования веб-страниц (ключ — URL страницы, значение — статус ответа),
//выведите сообщение о странице и статусе её проверки.
    val webPagesResults = mapOf("url_1" to 200, "url_2" to 302, "url_3" to 503, "url_4" to 429)
    webPagesResults
        .map { "${it.key}: status ${it.value}" }
        .forEach { println(it) }


//Найдите в словаре с названием и временем ответа сервисов только те, время ответа которых превышает заданный порог.
    val responseTime = 10
    val serviceResponses = mapOf("service_1" to 11, "service_2" to 8, "service_3" to 9, "service_4" to 12)
    println(serviceResponses.filterValues { it > responseTime })


//В словаре хранятся результаты тестирования API (ключ — endpoint, значение — статус ответа в строке).
//Для указанного endpoint найдите статус ответа, если endpoint отсутствует, предположите, что он не был протестирован.
    val apiTests = mapOf("endpoint_1" to "STATUS: 200", "endpoint_2" to "STATUS: 204", "endpoint_3" to "STATUS: 201")
    println(apiTests.getOrDefault("endpoint_6", "Not tested"))


//Из словаря, содержащего конфигурации тестового окружения (ключ — название параметра конфигурации),
//получите значение для "browserType". Ответ не может быть null.
    val configs = mutableMapOf("browserType" to "FireFox", "systemType" to "Debian", "cloudService" to "Azure")
    configs.getOrElse("browserType") {throw Exception("Specified config parameter was not added")}


//Создайте копию неизменяемого словаря с данными о версиях тестируемого ПО, чтобы добавить новую версию.
    val testVersions = mapOf("APP1" to listOf("v1.0", "v1.12"), "APP2" to listOf("v1.32", "v3.01"))
    val testVersionsUpdated = testVersions + ("APP34" to listOf("v1.65", "v3.566"))
    println(testVersionsUpdated)


//Используя словарь с настройками тестирования для различных мобильных устройств (ключ — модель устройства),
//получите настройки для конкретной модели или верните настройки по умолчанию.
    val mobileTestSettings = mapOf("Samsung" to "settings_1234", "Huawei" to "settings_5678")
    println(mobileTestSettings.getOrDefault("Xiaomi", "Default settings"))


//Проверьте, содержит ли словарь с ошибками тестирования (код и описание) определенный код ошибки
    val errors = mapOf(404 to "Not found", 400 to "Bad Request", 403 to "Forbidden")
    println(errors.containsKey(401))


//Дан неизменяемый словарь, где ключи — это идентификаторы тестовых сценариев в формате "TestID_Version",
// а значения — статусы выполнения этих тестов ("Passed", "Failed", "Skipped"). Отфильтруйте словарь,
// оставив только те сценарии, идентификаторы которых соответствуют определённой версии тестов.
    val testCases = mapOf("Test_1" to "Failed", "Test_2" to "Failed", "Test_3" to "Skipped")
    println(testCases.filterKeys { it == "Test_3"})


//У вас есть словарь, где ключи — это названия функциональных модулей приложения,
//а значения — результаты их тестирования. Проверьте, есть ли модули с неудачным тестированием.
    val testModules = mapOf("Devices" to "Failed", "Actions" to "Skipped", "Alerts" to "Failed", "Storage" to "Passed")
    println(testModules.any { it.value == "Failed" })


//Добавьте в изменяемый словарь с настройками тестовой среды настройки из другого словаря.
    val settingsEnv1 = mutableMapOf("settings_1" to "value_1", "settings_2" to "value_2")
    val settingsEnv2 = mutableMapOf("settings_3" to "value_3", "settings_4" to "value_4")
    settingsEnv1["settings_3"] = settingsEnv2.getOrDefault("settings_3", "default_value")


//Объедините два неизменяемых словаря с данными о багах
    val bugs1 = mutableMapOf("bug1" to "critical", "bug2" to "major")
    val bugs2 = mutableMapOf("bug3" to "minor", "bug4" to "average")
    val allBugs = bugs1 + bugs2
    println(allBugs)


//Очистите изменяемый словарь с временными данными о последнем прогоне автоматизированных тестов.
    val lastSuiteRun = mutableMapOf("test1" to 234, "test2" to 1234)
    lastSuiteRun.clear()


//Исключите из отчета по автоматизированному тестированию те случаи, где тесты были пропущены (имеют статус “skipped”)
    println(testModules.filterNot { it.value == "Skipped" })


//Удалите из словаря с конфигурациями тестирования набор устаревших конфигураций.
    configs.remove("systemType")

//Создайте отчет о тестировании, преобразовав словарь с результатами тестирования (ключ — идентификатор теста,
// значение — результат) в список строк формата "Test ID: результат".
    val testResultsReport = mapOf("Test 4377" to "Failed",
        "Test 4567" to "Skipped",
        "Test 3457" to "Passed with warnings",)
    println(testResultsReport
        .map { "${it.key}: ${it.value}" }
        .joinToString("; "))


//Преобразуйте изменяемый словарь с результатами последнего тестирования в неизменяемый для архивации.
    val archivedReport = testResultsReport.toMap()
    println(archivedReport)


//Преобразуйте словарь, содержащий ID теста и данные о времени выполнения тестов,
// заменив идентификаторы тестов на их названия (название можно получить вызвав фейковый метод, например
// getNameById(id: String))
    val testResults1 = mapOf("Test 4678" to 233,
        "Test 8996" to 456,
        "Test 1290" to 7789,)

    fun getNameById(id: String): String {
        return when (id) {
            "Test 4678" -> "Login Test"
            "Test 8996" -> "Registration Test"
            "Test 1290" -> "Checkout Test"
            else -> "Unknown Test"
        }
    }
    println(testResults1.mapKeys { getNameById(it.key) })


//Для словаря с оценками производительности различных версий приложения увеличьте каждую оценку
// на 10%, чтобы учесть новые условия тестирования.
    val performanceRate = mapOf("v1" to 8.2, "v2" to 4.8, "v3" to 1.9)
    println(performanceRate.mapValues { it.value * 1.1 })


//Проверьте, пуст ли словарь с ошибками компиляции тестов.
    val errorCompilations = mapOf<String, String>()
    println(errorCompilations.isEmpty())


//Убедитесь, что словарь с результатами нагрузочного тестирования не пуст.
    println(performanceRate.isNotEmpty())


//Проверьте, прошли ли успешно все автоматизированные тесты в словаре с результатами
    println(testModules.all {it.value == "Passed"})


//Определите, содержит ли словарь с результатами тестирования хотя бы один тест с ошибкой.
    println(testModules.any() {it.value == "Failed"})


//Отфильтруйте словарь с результатами тестирования сервисов, оставив только те тесты,
// которые не прошли успешно и содержат в названии “optional”
    val testResults2 = mapOf("optional s1" to "Passed", "s2" to "Passed", "s3" to "Skipped", "optional s4" to "Passed")
    println(testResults2
        .filter { it.key.contains("optional")}
        .filter {it.value == "Passed"})
}