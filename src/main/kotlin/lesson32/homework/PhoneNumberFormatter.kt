package com.pavel.likholap.lesson32.homework

class PhoneNumberFormatter {
    fun formatPhoneNumber(input: String): String {
        val replaced = input.replace("\\D".toRegex(), "")
        val res = when {
            replaced.length == 10 && (!replaced.startsWith('7') && !replaced.startsWith('8')) -> "+7$replaced"
            replaced.length == 11 && (replaced.startsWith('7') || replaced.startsWith('8')) ->
                "+7" + replaced.substring(1)

            else -> throw InvalidPhoneNumberError("Invalid number")
        }
        return "${res.substring(0, 2)} (${res.substring(2, 5)}) " +
                "${res.substring(5, 8)}-${res.substring(8, 10)}-${res.substring(10)}"
    }
}
