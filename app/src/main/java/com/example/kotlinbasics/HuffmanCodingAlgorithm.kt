package com.example.kotlinbasics

import java.util.*

data class HuffmanNode(
    var data: Char,
    var frequency: Int,
    var left: HuffmanNode? = null,
    var right: HuffmanNode? = null
)

fun buildHuffmanTree(text: String): HuffmanNode? {
    val frequencyMap = mutableMapOf<Char, Int>()

    // Count frequencies of characters in the text
    for (char in text) {
        frequencyMap[char] = frequencyMap.getOrDefault(char, 0) + 1
    }

    val priorityQueue = PriorityQueue<HuffmanNode> { a, b -> a.frequency - b.frequency }

    // Create a leaf node for each character and add it to the priority queue
    for ((char, freq) in frequencyMap) {
        priorityQueue.add(HuffmanNode(char, freq))
    }

    // Combine the two nodes with the lowest frequency until the priority queue has only one node left
    while (priorityQueue.size > 1) {
        val left = priorityQueue.poll()
        val right = priorityQueue.poll()

        val newNode = HuffmanNode('\u0000', left.frequency + right.frequency, left, right)
        priorityQueue.add(newNode)
    }

    // Return the root node of the Huffman tree
    return priorityQueue.poll()
}

fun encode(root: HuffmanNode?, str: String, codeMap: MutableMap<Char, String>, code: String) {
    if (root == null) return

    // If the node is a leaf node, store the code
    if (root.left == null && root.right == null) {
        codeMap[root.data] = code
    }

    // Traverse left with code '0' and right with code '1'
    encode(root.left, str, codeMap, code + "0")
    encode(root.right, str, codeMap, code + "1")
}

fun huffmanEncode(text: String): String {
    val root = buildHuffmanTree(text)
    val codeMap = mutableMapOf<Char, String>()
    encode(root, text, codeMap, "")

    val encodedStringBuilder = StringBuilder()
    for (char in text) {
        encodedStringBuilder.append(codeMap[char])
    }

    return encodedStringBuilder.toString()
}

fun main() {
    val text = "Huffman coding is a data compression algorithm."
    val encodedText = huffmanEncode(text)

    println("Original text: $text")
    println("Encoded text: $encodedText")
}