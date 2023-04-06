package com.example.kotlinbasics

fun main() {
//    val result = returnAll(2, 4, 4.7, "Yes! It is working", 5.89f)
//    val (first, second, third, fourth, fifth) = result
//    println("First = $first, Second = $second, Third = $third, Fourth = $fourth, Fifth = $fifth")

    val (name, rollnumber, gender) = getStudentDetails() //destructuring declaration
    println("$name\n$rollnumber\n$gender")
}

//fun returnAll(a: Int, b: Int, c: Double, d: String, e: Float) = CustomReturn(a, b, c, d, e)

//data class CustomReturn<A, B, C, D, E>(
//    val first: A,
//    val second: B,
//    val third: C,
//    val fourth: D,
//    val fifth: E
//)

data class StudentModel(var name: String, var rollnumber: Int, var gender: Char)

fun getStudentDetails(name: String = "Fuad", rollnumber: Int = 54546, gender: Char = 'M') =
//    StudentModel(name, rollnumber, gender)
//    Triple(name, rollnumber, gender)
    arrayOf(name, rollnumber, gender)