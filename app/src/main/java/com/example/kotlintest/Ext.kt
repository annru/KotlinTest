package com.example.kotlintest

class Ext {


}

fun String.clean(): String {
    return this.replace("[^A-Za-z]".toRegex(), " ").trim()
}

fun List<String>.getWordCount(): Map<String, Int> {
    val map = hashMapOf<String, Int>()
    for (word in this) {
        if (word == "") continue
        val trim = word.trim()
        val count = map.getOrDefault(trim, 0)
        map[trim] = count + 1
    }
    return map
}

fun <T> Map<String, Int>.mapToList(transform: (Map.Entry<String, Int>) -> T): MutableList<T> {
    val list = mutableListOf<T>()
    for (entry in this) {
        val freq = transform(entry)
        list.add(freq)
    }
    return list
}