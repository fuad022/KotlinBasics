package com.example.kotlinbasics

fun main() {
    val original = "AAAABBBCCDAA"
    val encoded = encodeRLE(original)
    val decoded = decodeRLE(encoded)

    println("Original: $original")
    println("Encoded: $encoded")
    println("Decoded: $decoded")
}

fun encodeRLE(input: String): String {
    if (input.isEmpty()) return ""

    val encoded = StringBuilder()
    var count = 1
    var prevChar = input[0]

    for (i in 1 until input.length) {
        if (input[i] == prevChar) {
            count++
        } else {
            encoded.append(count)
            encoded.append(prevChar)
            count = 1
            prevChar = input[i]
        }
    }

    encoded.append(count)
    encoded.append(prevChar)

    return encoded.toString()
}

fun decodeRLE(input: String): String {
    if (input.isEmpty()) return ""

    val decoded = StringBuilder()
    var count = 0
    var i = 0

    while (i < input.length) {
        var numStr = ""
        while (i < input.length && input[i].isDigit()) {
            numStr += input[i]
            i++
        }
        count = numStr.toInt()

        val char = input[i]
        repeat(count) {
            decoded.append(char)
        }

        i++
    }

    return decoded.toString()
}