package com.example.kotlinbasics

import java.security.MessageDigest

fun main() {
    val fba = FBA()

    val node1 = NodeFBA(1, "Node 1")
    val node2 = NodeFBA(2, "Node 2")
    val node3 = NodeFBA(3, "Node 3")

    fba.addNode(node1)
    fba.addNode(node2)
    fba.addNode(node3)

    fba.sendMessage("Agree on this message")

    val agreedValue = fba.agreeOnValue()
    println("Agreed value: $agreedValue")
}

data class NodeFBA(val id: Int, val name: String)

class FBA {
    private val nodes = mutableListOf<NodeFBA>()
    private val messages = mutableListOf<String>()

    fun addNode(node: NodeFBA) {
        nodes.add(node)
    }

    fun sendMessage(message: String) {
        messages.add(message)
    }

    fun agreeOnValue(): String {
        val agreedMessage = messages.groupBy { it }.maxByOrNull { it.value.size }?.key
        val hash = hash(agreedMessage ?: "")
        val decision = nodes.filter { hash(it.name) < hash }

        return if (decision.size > nodes.size / 2) {
            agreedMessage ?: ""
        } else {
            "No agreement reached."
        }
    }

    private fun hash(message: String): Int {
        val bytes = MessageDigest.getInstance("SHA-256").digest(message.toByteArray())
        return bytes.fold(0) { acc, byte -> (acc shl 8) or byte.toInt() }
    }
}