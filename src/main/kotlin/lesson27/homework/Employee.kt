package com.pavel.likholap.lesson27.homework

class Employee(name: String, age: Int, val position: String): Person(name, age) {
    var department: String = "General"
}