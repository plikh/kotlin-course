package com.pavel.likholap.lesson24.homework

/*
Задание 5. Создай свой тип исключения в отдельном файле, наследуемый от RuntimeException и принимающий
ArrayIndexOutOfBoundsException тип в качестве аргумента. Напиши код, который спровоцирует выброс
ArrayIndexOutOfBoundsException, перехвати его с помощью try-catch и в блоке catch выведи сообщение
в консоль и сделай выброс своего типа исключения.
 */

class CustomErrorSecond(arg: ArrayIndexOutOfBoundsException): RuntimeException(arg)