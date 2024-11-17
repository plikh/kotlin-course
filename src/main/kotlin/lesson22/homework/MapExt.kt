package com.pavel.likholap.lesson22.homework

fun <K> Map<K, List<K>>?.getMapExt(a: Int): Map<String, K?>? {
    if (this.isNullOrEmpty()) return null
    return this.entries.associate { it.key.toString() to  it.key}
}