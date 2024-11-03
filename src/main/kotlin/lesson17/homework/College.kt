package com.pavel.likholap.lesson17.homework

class College(name: String, private val courses: List<String>) : EducationalInstitution(name) {
    fun getCourseList(): String {
        return "$name has following courses: ${courses.joinToString(", ")}."
    }
}