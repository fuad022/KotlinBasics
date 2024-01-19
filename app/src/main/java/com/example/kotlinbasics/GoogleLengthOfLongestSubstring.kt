package com.example.kotlinbasics

fun main() {
    val input = "abcabcbb"
    val result = lengthOfLongestSubstring(input)
    println("The length of the longest substring with no repeating characters is: $result")
}

fun lengthOfLongestSubstring(s: String): Int {
    val n = s.length
    var maxLength = 0
    var start = 0
    val charIndexMap = mutableMapOf<Char, Int>()

    for (end in 0 until n) {
        if (charIndexMap.containsKey(s[end])) {
            // If the character is already in the substring, update the start index
            start = maxOf(start, charIndexMap[s[end]]!! + 1)
        }

        // Update the character's last index
        charIndexMap[s[end]] = end

        // Update the maximum length
        maxLength = maxOf(maxLength, end - start + 1)
    }

    return maxLength
}