package com.pavel.likholap.lesson17.homework

open class School(
    name: String,
    val level: String): EducationalInstitution(name) {

        fun getDescription(): String{
            return "Welcome to $level school"
        }

}