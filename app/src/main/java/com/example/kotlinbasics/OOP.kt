package com.example.kotlinbasics

import androidx.collection.ArrayMap
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

fun main() {
    val alice: Person = Person("Alice", 24)
//    val kate = alice.copy(name = "Kate")
//    println(alice.toString())
//    println(kate.toString())

    val (username, userage) = alice
//    println("Name: $username Age: $userage")


    val arrayList = arrayListOf("one", "two", "three")
    arrayList.add("four")
    arrayList.removeAt(0)
    println(arrayList[1])

    val arrayMap = ArrayMap<String, Int>()
    arrayMap["one"] = 1
    arrayMap["two"] = 2
    arrayMap["three"] = 3
    println(arrayMap["two"])
    
}



data class Person(val name: String, val age: Int)

//
sealed class HttpError {
    object Unauthorized : HttpError()
    object NotFound : HttpError()
}