package com.example.kotlinbasics

fun main() {
    val word = "word"
    val abbreviations = generateAbbreviations(word)
    abbreviations.forEach { println(it) }
}

fun generateAbbreviations(word: String): List<String> {
    val result = mutableListOf<String>()
    generateAbbreviationsHelper(word, 0, "", 0, result)
    return result
}

fun generateAbbreviationsHelper(
    word: String, index: Int, currentAbbreviation: String,
    count: Int, result: MutableList<String>
) {
    if (index == word.length) {
        if (count > 0) {
            result.add("$currentAbbreviation$count")
        } else {
            result.add(currentAbbreviation)
        }
        return
    }

    generateAbbreviationsHelper(word, index + 1, currentAbbreviation, count + 1, result)

    if (count > 0) {
        generateAbbreviationsHelper(
            word,
            index + 1,
            "$currentAbbreviation$count${word[index]}",
            0,
            result
        )
    } else {
        generateAbbreviationsHelper(
            word,
            index + 1,
            "$currentAbbreviation${word[index]}",
            0,
            result
        )
    }
}