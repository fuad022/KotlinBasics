package com.example.kotlinbasics

fun main() {
    val trie = TrieLWD()

    val dictionary = listOf("apple", "banana", "apricot", "bat", "batman", "batwoman")
    for (word in dictionary) {
        trie.insert(word)
    }

    val longestWord = trie.searchLongestWord()

    println("Longest word in the dictionary: $longestWord")
}

class TrieNodeLWD {
    val children = mutableMapOf<Char, TrieNodeLWD>()
    var isEndOfWord = false
}

class TrieLWD {
    val root = TrieNodeLWD()

    fun insert(word: String) {
        var node = root
        for (char in word) {
            node = node.children.computeIfAbsent(char) { TrieNodeLWD() }
        }
        node.isEndOfWord = true
    }

    fun searchLongestWord(): String {
        var result = ""
        val stack = mutableListOf<Pair<TrieNodeLWD, String>>()
        stack.add(Pair(root, ""))

        while (stack.isNotEmpty()) {
            val (node, currentWord) = stack.removeAt(stack.size - 1)

            if (node.isEndOfWord) {
                if (currentWord.length > result.length || (currentWord.length == result.length && currentWord < result)) {
                    result = currentWord
                }
            }

            for ((char, child) in node.children) {
                stack.add(Pair(child, currentWord + char))
            }
        }

        return result
    }
}