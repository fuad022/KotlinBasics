package com.example.kotlinbasics

fun main() {
    val sampleList = listOf(1, 2, 3, 4, 5, 6)
    val even = sampleList.filter { it % 2 == 0 }
    println(" the even numbers are $even")
    val sampleSet = setOf(1, 2, 3, 4, 5, 6)
    val odd = sampleSet.filter { it % 2 == 1 }
    println(" the odd numbers are $odd")

    ///////////////////////////////////////

    val sampleList2 = listOf(PersonMC("karthiq", 27), PersonMC("chercherTech", 1))
    // lets filter object which has age is less than 10
    println(sampleList2.filter { it.age < 10 })

    ///////////////////////////////////////

    val sampleMap = mapOf(1 to "one", 2 to "two", 3 to "three", 4 to "four")
    val even2 = sampleMap.filterKeys { it % 2 == 0 }
    println(" the even numbered keys are :$even2")
    val odd2 = sampleMap.filterValues { it == "two" }
    println(" the value which match with 'two' :$odd2")
}

data class PersonMC(var name: String, var age: Int)