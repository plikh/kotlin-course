package com.pavel.likholap.lesson17.homework

class MiddleSchool(
    name: String,
    level: String
): School(name, level) {
    fun getSchoolName(): String {
        return name
    }
}