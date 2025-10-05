package com.example.kotlinbasics

fun main() {
    val s = "abcabcbb"
    val k = 2

    val result = longestSubstringWithKDistinct(s, k)

    println("Longest substring with at most $k distinct characters: $result")
}

fun longestSubstringWithKDistinct(s: String, k: Int): String {
    if (k <= 0) return ""

    var start = 0
    var end = 0
    var maxSubstringStart = 0
    var maxSubstringLength = 0
    val charFrequency = mutableMapOf<Char, Int>()

    while (end < s.length) {
        val currentChar = s[end]

        charFrequency[currentChar] = charFrequency.getOrDefault(currentChar, 0) + 1

        while (charFrequency.size > k) {
            val startChar = s[start]
            charFrequency[startChar] = charFrequency[startChar]!! - 1
            if (charFrequency[startChar] == 0) {
                charFrequency.remove(startChar)
            }
            start++
        }

        val currentLength = end - start + 1

        if (currentLength > maxSubstringLength) {
            maxSubstringStart = start
            maxSubstringLength = currentLength
        }

        end++
    }

    return s.substring(maxSubstringStart, maxSubstringStart + maxSubstringLength)
}