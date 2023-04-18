package com.example.kotlinbasics

import androidx.collection.ArrayMap
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import java.util.*

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
//    println(arrayList[1])
//    println(arrayList)

    val arrayMap = ArrayMap<String, Int>()
    arrayMap["one"] = 1
    arrayMap["two"] = 2
    arrayMap["three"] = 3
//    println(arrayMap["two"])
//    println(arrayMap)

//    val myArray = arrayOf(1, 2, 3, 4, 5)
    val myArray = Array(5) { i -> i * i }
//    println(Arrays.toString(myArray))
//    println(myArray.contentToString())
    val str = myArray.joinToString(separator = "; ", prefix = "{", postfix = "}")
//    println(str)

    val numbers = listOf(1, 2, 3, 4, 5)
//    val sum = numbers.reduce { acc, next -> acc + next }
//    println(sum)

    val sum = numbers.fold(1) { acc, next -> acc + next }
//    println(sum)

    val str1 = "Hello World"
    val newStr = str1.removeSpaces()
//    println(newStr)

    val intArray = IntArray(10)
    println(intArray.contentToString())
}



fun String.removeSpaces() =
    this.replace(" ", "")


data class Person(val name: String, val age: Int)

//
sealed class HttpError {
    object Unauthorized : HttpError()
    object NotFound : HttpError()
}