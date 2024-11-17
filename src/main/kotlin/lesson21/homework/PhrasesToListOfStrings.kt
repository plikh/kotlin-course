package com.pavel.likholap.lesson21.homework


//Создай класс PhrasesToListOfStrings и имплементируй интефрейс Mapper с типами String и List<String>.
//Метод преобразования должен разбивать входящую строку по символу пробела и возвращать список из полученных слов.

class PhrasesToListOfStrings: Mapper< String, List<String>>
{
    override fun changeItemType(item: String): List<String> {
        return item.split(" ")
    }

    override fun changeListItems(items: List<String>): List<List<String>> {
        return items.map { changeItemType(it) }
    }
}