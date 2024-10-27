package com.pavel.likholap.lesson15.homework


/*
Природное явление: Луна Создайте объект Moon, который будет представлять Луну. Добавьте свойства isVisible (Boolean),
чтобы отображать, видна ли Луна в данный момент, и phase (String), чтобы отображать текущую фазу Луны
(например, "Full Moon", "New Moon"). Добавьте метод showPhase(), который выводит текущую фазу Луны.
 */

class Moon(private val isVisible: Boolean, private val phase: String) {
    private fun showPhase(): String{
        return if (isVisible) phase else "Not visible"
    }
}