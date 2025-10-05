package com.example.kotlinbasics

fun main() {
    val input = "abcabcbb"
    val result = lengthLongestSubstring(input)
    println("Length of the longest substring without repeating characters: $result")
}

fun lengthLongestSubstring(s: String): Int {
    val n = s.length
    var maxLen = 0
    var left = 0
    val charIndexMap = mutableMapOf<Char, Int>()

    for (right in 0 until n) {
        val currentChar = s[right]
        if (charIndexMap.containsKey(currentChar)) {
            left = maxOf(left, charIndexMap[currentChar]!! + 1)
        }
        charIndexMap[currentChar] = right
        maxLen = maxOf(maxLen, right - left + 1)
    }

    return maxLen
}