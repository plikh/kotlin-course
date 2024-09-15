package com.pavel.likholap.homework_3

import kotlin.random.Random

//Название мероприятия
const val PARTY: String = "PARTY_NA_KROVATY"

//Дата проведения
var partyDate: String = "09/22/2024"

//Место проведения
val partyLocation: String = "Milk bar"

//Подробный бюджет мероприятия, включая расходы на оборудование, кейтеринг и другие операционные расходы.
var commonBudget: String = "some data"

//Количество участников
var membersCount: Int = 5
    get() = field
    set(value) {
        if (value in 6..60) field = value
    }

//Длительность хакатона
var partyDuration: Int = 5

//Контактная информация и условия соглашений с поставщиками пищи, оборудования и других услуг.
val confirmation: String = "some data"

//Текущее состояние хакатона (статус)
var currentStatus: String = "Not started"

//Список спонсоров
val sponsorsList: String = "some data"

//Бюджет мероприятия
var budget: String = "some data"

//Текущий уровень доступа к интернету
lateinit var currentConnectionLevel: String

//Информация о транспортировке оборудования, распределении ресурсов и координации между различными командами поддержки.
val staffInfo: String = "some data"

//Количество команд
var teamsCount: Int = 3
    get() = field
    set(value) {
        if (value in 4..10) field =value
    }
//Перечень задач
var tasks: String = "some data"

//План эвакуации
const val EVACUATION_PLAN: String = "some data"

//Список доступного оборудования
var enabledToolsList: String = "some data"

//Список свободного оборудования
var freeToolsList: String = "some data"

//График питания участников (зависит от поставщика питания, определяемого за неделю до начала)
val eatingPlan: String = "some plan"

//План мероприятий на случай сбоев
val activitiesPlanFailCase: String = "some plan"

//Список экспертов и жюри
val expertsList: String = "some experts"

//Методы и процедуры для сбора отзывов от участников и гостей, включая анонимные опросы и интервью.
val collectMethods: String = "some methods"

//Политика конфиденциальности
val privatPolicy: String = "some policy"

//Приватные отзывы (фидбэк) участников и зрителей для анализа проблем.
lateinit var feedbackFromMembers: String

//Текущая температура в помещении
var currentTemperature: Int = 21

//Мониторинг и анализ производительности сетевого оборудования и интернет-соединения.
lateinit var performanceAnalyze: String

//Уровень освещения
lateinit var lightingLevel: String

//Лог событий мероприятия
private var eventLog: String = ""
    set(value){field += value}

//Доступность медицинской помощи
val medicalAvailable: Boolean = true

//Планы и процедуры для обеспечения безопасности мероприятия, включая планы эвакуации и протоколы чрезвычайных ситуаций.
val securityPlans: String = "some data"

//Регистрационный номер мероприятия
const val regNumberParty: String = "A12WE45L1LMD"
//Максимально допустимый уровень шума в помещении хакатона.
val maxNoiseLevel: Int = 11

//Индикатор превышения уровня шума в помещениях
var NoiseIndicator: Boolean? = null

//Формат мероприятия (зависит от геополитической обстановки)
var partyForm: String = "some form"

//Статус получения всех необходимых разрешений
var permissionsStatus: String = "status"

//Указывает, открыт ли доступ к эксклюзивным ресурсам (например, специальному оборудованию)
lateinit var resourcesAccess: String

//Список партнеров мероприятия
var partnersList: String = "partners list"

//Отчет, включающий фотографии, видео и отзывы, генерируется и становится доступен после завершения мероприятия.
lateinit var partyReport: String

//План распределения призов
var prizesPlan: String = ""

//Контактная информация экстренных служб, медицинского персонала и других важных служб, недоступная участникам.
val contactsServices: String = "911"

//Особые условия для участников с ограниченными возможностями
var membersConditions: String = "some data"

//Общее настроение участников (определяется опросами)
lateinit var currentPartyStatus: String

//Подробный план хакатона, включающий время и содержание каждого сегмента, инициализируется непосредственно перед началом мероприятия.
lateinit var generalPartyPlan: String

//Имя знаменитого специального гостя, которое будет объявлено за день до мероприятия.
lateinit var famousPerson: String

//Максимальное количество людей, которое может вместить место проведения.
val maxMembersCount: Int = 100

//Стандартное количество часов, отведенное каждой команде для работы над проектом.
val availableHours: Int = 1
