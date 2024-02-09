package com.example.kotlinbasics

import java.security.MessageDigest

fun main() {
    val blockchain = Blockchain()

    blockchain.addBlock("Transaction 1")
    blockchain.addBlock("Transaction 2")
    blockchain.addBlock("Transaction 3")

    blockchain.printBlockchain()

    println("Is the blockchain valid? ${blockchain.isChainValid()}")
}

// Block class represending a block in the blockchain
data class Block(
    val index: Int,
    val timestamp: Long,
    val data: Any,
    val previousHash: String,
    val hash: String
)

// Blockchain class managing the blocks
class Blockchain {
    private val blockchain = mutableListOf<Block>()

    init {
        // Create the genesis block
        blockchain.add(generateGenesisBlock())
    }

    // Generates the genesis block with arbitrary data
    private fun generateGenesisBlock(): Block {
        return Block(
            0,
            System.currentTimeMillis(),
            "Genesis Block",
            "0",
            calculateHash(0, System.currentTimeMillis(), "Genesis Block", "0")
        )
    }

    // Adds a new block to the blockchain
    fun addBlock(data: Any) {
        val previousBlock = blockchain[blockchain.size - 1]
        val newIndex = previousBlock.index + 1
        val newBlock = Block(
            newIndex,
            System.currentTimeMillis(),
            data,
            previousBlock.hash,
            calculateHash(newIndex, System.currentTimeMillis(), data, previousBlock.hash)
        )
        blockchain.add(newBlock)
    }

    // Calculate the hash of a block
    private fun calculateHash(
        index: Int,
        timestamp: Long,
        data: Any,
        previousHash: String
    ): String {
        val input = "$index$timestamp$data$previousHash"
        val bytes = MessageDigest.getInstance("SHA-256").digest(input.toByteArray())
        return bytes.joinToString("") { "%02x".format(it) }
    }

    // Checks if the blockchain is valid
    fun isChainValid(): Boolean {
        for (i in 1 until blockchain.size) {
            val currentBlock = blockchain[i]
            val previousBlock = blockchain[i - 1]

            if (currentBlock.hash != calculateHash(
                    currentBlock.index,
                    currentBlock.timestamp,
                    currentBlock.data,
                    previousBlock.hash
                )
            ) {
                return false
            }
        }
        return true
    }

    // Prints the blockchain
    fun printBlockchain() {
        for (block in blockchain) {
            println("Index: ${block.index}, Timestamp: ${block.timestamp}, Data: ${block.data}, Previous Hash: ${block.previousHash}, Hash: ${block.hash}")
        }
    }
}