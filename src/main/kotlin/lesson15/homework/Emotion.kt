package com.pavel.likholap.lesson15.homework

/*
Аспект реальности: Эмоция Создайте класс Emotion, который представляет эмоцию.
У него должно быть свойство type (String) и intensity (Int). Добавьте метод express(),
который выводит описание эмоции в зависимости от её типа и интенсивности.
*/

class Emotion(private val type: String, private val intensity: Int) {
    fun express(): String {
        return when (intensity) {
            in 1..5 -> "Normal $type"
            in 6..10 -> "Strong $type"
            else -> "Unknown intensity"
        }
    }

}