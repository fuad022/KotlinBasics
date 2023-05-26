package com.example.kotlinbasics


val peopleTestSet = mutableSetOf<Persons>()
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

    ///////////////////////////////////////////////////


    val objects1 = listOf(
        MyObject(1, true),
        MyObject(2, false),
        MyObject(3, true)
    )

    val peopleTestList = listOf(
        Persons("Alice", 25, objects1),
        Persons("Bob", 20, objects1),
        Persons("Charlie", 30, objects1),
        Persons("David", 25, objects1),
        Persons("Max", 20, objects1)
    )

//    val peopleTestSet = mutableSetOf(
//        Persons("Alice", 25, objects1),
//        Persons("Bob", 20, objects1),
//        Persons("Charlie", 30, objects1),
//        Persons("David", 25, objects1)
//    )

//    peopleTestSet.add(Persons("Alice", 25, objects1))
    addSet(Persons("Alice", 25, objects1))
    addSet(Persons("Bob", 20, objects1))

    removeSet(Persons("Bob", 20, objects1))

    val result = peopleTestList.minus(peopleTestSet)
    println(result.size)
}

fun addSet(obj: Persons) {
    peopleTestSet.add(obj)
}

fun removeSet(obj: Persons) {
    peopleTestSet.remove(obj)
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
