package com.example.kotlinbasics

fun main() {
    val input = "abc"
    val permutations = generateCasePermutations(input)

    println("String Permutations with Case Change:")
    permutations.forEach { println(it) }
}

fun generateCasePermutations(input: String): List<String> {
    val result = mutableListOf<String>()
    generateCasePermutationsRecursive(input.toCharArray(), 0, result)
    return result
}

fun generateCasePermutationsRecursive(
    charArray: CharArray,
    currentIndex: Int,
    result: MutableList<String>
) {
    if (currentIndex == charArray.size) {
        result.add(String(charArray))
        return
    }

    // Process the current character with lowercase
    charArray[currentIndex] = charArray[currentIndex].lowercaseChar()
    generateCasePermutationsRecursive(charArray, currentIndex + 1, result)

    // Process the current character with uppercase
    charArray[currentIndex] = charArray[currentIndex].uppercaseChar()
    generateCasePermutationsRecursive(charArray, currentIndex + 1, result)

    // Restore the character to its original state for backtracking
    charArray[currentIndex] = charArray[currentIndex].lowercaseChar()
}