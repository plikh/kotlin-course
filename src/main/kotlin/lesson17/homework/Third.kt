package com.pavel.likholap.lesson17.homework

//Третий класс должен добавлять элементы в список в алфавитном порядке.
//Если мы добавляем новый элемент в список, то он должен встать где-то между
//другими элементами и занять место в соответствии с сортировкой по алфавиту.

class Third: Materials(){
    fun addByOrder(newMaterials: MutableList<String>){
        (extractMaterial().toMutableList() + newMaterials).sorted().forEach {addMaterial(it)}

    }
}