package com.pavel.likholap.lesson17.homework

class University(name: String, private val facultyCount: Int): EducationalInstitution(name) {
    fun getFacultyCount(): Int{
        return facultyCount
    }
}