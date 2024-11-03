package com.pavel.likholap.lesson17.homework

class PrimarySchool(
    name: String,
    level: String
): School(name, level) {
    fun getBasicProgram(): String {
        return "Check basic program on site: https://psnumberone.com"
    }
}