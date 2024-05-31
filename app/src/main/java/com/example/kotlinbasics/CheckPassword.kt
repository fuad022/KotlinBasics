package com.example.kotlinbasics

fun main() {
    println(checkPass("2127"))
}

fun checkPass(text: String): Boolean {
    // mapNotNull - filter out non-digit characters and check for invalid input.
    val digits = text.mapNotNull { it.toString().toIntOrNull() }
    if (digits.size != text.length) return false

    // digits.zipWithNext() creates a list of pairs of adjacent elements.
    // count { (a, b) -> a == b - 1 } counts the pairs where the first element is one less than the second (ascending).
    val ascCount = digits.zipWithNext().count { (a, b) -> a == b - 1 }
    // count { (a, b) -> a == b + 1 } counts the pairs where the first element is one more than the second (descending).
    val descCount = digits.zipWithNext().count { (a, b) -> a == b + 1 }

    return when {
        ascCount == 3 -> false
        descCount == 3 -> false
        digits.size >= 4 && digits[0] == digits[1] && digits[2] == digits[3] -> false
        else -> true
    }
}

//enum class Types {
//    ASCENDING,
//    DESCENDING,
//    COUPLE,
//    NONE
//}

//fun checkPass(text: String): Types {
//    // mapNotNull - filter out non-digit characters and check for invalid input.
//    val characters = text.mapNotNull { it.toString().toIntOrNull() }
//    if (characters.size != text.length) return Types.NONE
//
//    // characters.zipWithNext() creates a list of pairs of adjacent elements.
//    // count { (a, b) -> a == b - 1 } counts the pairs where the first element is one less than the second (ascending).
//    val ascCount = characters.zipWithNext().count { (a, b) -> a == b - 1 }
//    // count { (a, b) -> a == b + 1 } counts the pairs where the first element is one more than the second (descending).
//    val descCount = characters.zipWithNext().count { (a, b) -> a == b + 1 }
//
//    return when {
//        ascCount == 3 -> Types.ASCENDING
//        descCount == 3 -> Types.DESCENDING
//        characters.size >= 4 && characters[0] == characters[1] && characters[2] == characters[3] -> Types.COUPLE
//        else -> Types.NONE
//    }
//}
