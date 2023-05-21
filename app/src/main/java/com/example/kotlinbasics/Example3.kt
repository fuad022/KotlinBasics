package com.example.kotlinbasics

fun main() {
//    println(groupWords(arrayOf("eat", "tea", "tan", "ate", "nat", "bat")))
//    println("Test message")

    val objects = listOf(
        MyObject(1, true),
        MyObject(2, false),
        MyObject(3, true)
    )

    val people = Persons("Alice", 25, objects)

    if (people.objects.filter { it.isActive }.size > 1) {
        println("Objects list more 1 size isActive")
    } else {
        println("Objects list no has isActive")
    }
}

data class Persons(val name: String, val age: Int, val objects: List<MyObject>)
data class MyObject(val id: Int, val isActive: Boolean)


fun groupWords(words: Array<String>): List<List<String>> {
    val result: MutableList<List<String>> = mutableListOf()

    val map = mutableMapOf<String, MutableList<String>>()

    for (word in words) {
        val sortedWord = word.toCharArray().sorted().joinToString("")

        if (map.containsKey(sortedWord))
            map[sortedWord]?.add(word)
        else
            map[sortedWord] = mutableListOf(word)
    }

    for ((key, value) in map) {
        result.add(value)
    }

    return result
}
