package com.example.kotlinbasics

fun main() {
    val text = "AABAACAADAABAABA"
    val pattern = "AABA"
    val index = rabinKarpSearch(text, pattern)
    if (index != -1)
        println("Pattern found at index $index")
    else
        println("Pattern not found")
}

fun rabinKarpSearch(text: String, pattern: String): Int {
    val prime = 101 // A prime number
    val d = 256 // Number of characters in the input alphabet

    val n = text.length
    val m = pattern.length
    var patternHash = 0 // Hash value for pattern
    var textHash = 0 // Hash value for text
    var h = 1

    // The value of h would be "pow(d, m-1)%prime"
    for (i in 0 until m - 1)
        h = (h * d) % prime

    // Calculate the hash value of pattern and the first window of text
    for (i in 0 until m) {
        patternHash = (d * patternHash + pattern[i].toInt()) % prime
        textHash = (d * textHash + text[i].toInt()) % prime
    }

    // Slide the pattern over text one by one
    for (i in 0..n - m) {
        // Check the hash values of current window of text and pattern
        // If the hash values match then only check for characters one by one
        if (patternHash == textHash) {
            var j = 0
            while (j < m) {
                if (text[i + j] != pattern[j])
                    break
                j++
            }
            if (j == m)
                return i
        }

        // Calculate hash value for next window of text: Remove leading digit
        // add trailing digit
        if (i < n - m) {
            textHash = (d * (textHash - text[i].toInt() * h) + text[i + m].toInt()) % prime

            // We might get negative value of t, converting it to positive
            if (textHash < 0)
                textHash += prime
        }
    }
    return -1
}