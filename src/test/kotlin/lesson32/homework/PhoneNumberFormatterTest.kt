package lesson32.homework


import com.pavel.likholap.lesson32.homework.InvalidPhoneNumberError
import com.pavel.likholap.lesson32.homework.PhoneNumberFormatter
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.assertThrows

import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.MethodSource

class PhoneNumberFormatterTest {

    private lateinit var formatter: PhoneNumberFormatter

    @BeforeEach
    fun setup() {
        formatter = PhoneNumberFormatter()
    }

    @ParameterizedTest
    @MethodSource("invalidNumbers")
    fun `should throw exception for invalid input data`(inputData: String) {
        val exception = assertThrows<InvalidPhoneNumberError> { formatter.formatPhoneNumber(inputData) }
        assertEquals("Invalid number", exception.message)
    }

    @ParameterizedTest
    @MethodSource("validNumbers")
    fun `should format input data to correct phone number`(inputData: String, expectedResult: String) {
        assertEquals(expectedResult, formatter.formatPhoneNumber(inputData))
    }


    companion object {
        @JvmStatic
        fun invalidNumbers() = listOf(
            "0",
            "y12+34as56789dd",
            "qwe123456789098:'",

            )


        @JvmStatic
        fun validNumbers(): List<Array<out Any>> = listOf(
            arrayOf("8 (922) asdasda941-11-11", "+7 (922) 941-11-11"),
            arrayOf("7922#$%^&*(9411111", "+7 (922) 941-11-11"),
            arrayOf("+7 922 941 11  -=jjbc     11", "+7 (922) 941-11-11")
        )


    }
}











