package com.example.kotlinbasics

import java.util.*
import kotlin.collections.ArrayList
import kotlin.collections.HashSet
import kotlin.collections.LinkedHashSet

val userModelList = ArrayList<User>()
val secondList = ArrayList<User>()
fun main() {
/*    println("Hello Kotlin")

    val items = listOf("apple", "banana", "orange")
    mutableListOf("apple", "banana", "orange")

    println(items)

    var a: String = "Hello"
    var b: String? = "Test"
    b = null

    b?.length

    val l = b?.length ?: -1

    b = if ((0..10).random() > 5) "asdf" else null
    val t = b!!.length

    testWhen(1)
    testWhen("Hello")

    val a = 10
    val b = 10
    val c = if (a > b) {
        println("a = $a")
        a
    } else {
        println("b = $b")
        b
    }

    val x = intArrayOf(1, 4)
    print(x.average()) */

    /*
    // List start
    var nums = listOf(1, 2, 3, 4, 5, null)
    var nums2: List<Int> = listOf(5, 6, 7)
//    print(nums.get(5))
//    print(nums.elementAt(5))
//    print(nums.elementAtOrNull(6))

    var numbers: ArrayList<Int> = arrayListOf(1, 2, 3, 4, 5)
    numbers.add(4)
    numbers.clear()
    for (n in numbers) {
        println(n)
    }

    var numbers2: MutableList<Int> = mutableListOf()
    numbers2.add(12)
    numbers2.add(0, 12)
    numbers2.addAll(0, listOf(-3, -2, -1))
    numbers2.removeAt(0)
    numbers2.remove(5)

    for (n in numbers2) {
        println(n)
    }
    // List end

    // Set start
    var setNums: Set<Int> = setOf(1, 2, 3, 4, 5)
    var setNums1: MutableSet<Int> = mutableSetOf(35, 36, 37)

    var num1: HashSet<Int> = hashSetOf(5, 6, 7)
    var num2: TreeSet<Int> = sortedSetOf(15, 16, 17)
    var num3: LinkedHashSet<Int> = linkedSetOf(25, 26, 27)
    var num4: MutableSet<Int> = mutableSetOf(35, 36, 37)
    // Set end

    // Map start

    // Map end
*/

//    setupUsers().forEachIndexed { index, user ->
////       println("index = $index, item = $user")
//        if (!user.isGroup) {
//            secondList.add(user)
//            println("isGroup false index = $index, item = $user")
//        } else {
//            secondList.add(user)
//            println("isGroup true index = $index, item = $user")
//        }
//    }
//    println(secondList.size)

//    val reader = Scanner(System.`in`)
//
//    print("Enter a number: ")
//    val num = reader.nextInt()
//
//    if (num % 2 == 0)
//        println("$num is even")
//    else
//        println("$num is odd")

    val a = arrayOf("a", "a", "b", "c", "c")
    val b1 = a.distinct()
    val b2 = a.toSet()
    val b3 = a.toMutableSet()
    val b4 = a.toHashSet()
    println(b1)
    println(b2)
    println(b3)
    println(b4)

}

private fun setupUsers(): ArrayList<User> {
    userModelList.add(User("Frank", "Marta", false))
    userModelList.add(User("Frank", "Martina", true))
    userModelList.add(User("Frank", "Gozales", false))
    userModelList.add(User("Frank", "Francis", true))
    return userModelList
}

//fun testWhen(input: Any) {
//    when (input) {
//        1 -> println("One")
//        2 -> println("Two")
//        in 10..20 -> println("From 10 to 20")
//        is String -> println("Is string ${input.length}")
//        else -> println("Some else")
//    }
//}
