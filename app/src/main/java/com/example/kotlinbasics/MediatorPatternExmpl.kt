package com.example.kotlinbasics

fun main() {
    val mediator = ChatMediatorImpl()

    val user1 = Users("Alice", mediator)
    val user2 = Users("Bob", mediator)

    mediator.addUser(user1)
    mediator.addUser(user2)

    user1.sendMessage("Hello, Bob!")
    user2.sendMessage("Hi, Alice!")
}

interface ChatMediator {
    fun sendMessage(message: String, user: Users)
}

class Users(val name: String, private val mediator: ChatMediator) {
    fun sendMessage(message: String) {
        mediator.sendMessage("$name: $message", this)
    }

    fun receiveMessage(message: String) {
        println("[$name] Received message: $message")
    }
}

class ChatMediatorImpl : ChatMediator {
    private val users = mutableListOf<Users>()

    fun addUser(user: Users) {
        users.add(user)
    }

    override fun sendMessage(message: String, user: Users) {
        users.filter { it != user }.forEach { it.receiveMessage(message) }
    }
}