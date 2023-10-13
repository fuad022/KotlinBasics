package com.example.kotlinbasics

// Step 1: Command interface
interface Command {
    fun execute()
}

// Step 2: ConcreteCommand
class TurnOnCommand(private val light: Light) : Command {
    override fun execute() {
        light.turnOn()
    }
}

class TurnOffCommand(private val light: Light) : Command {
    override fun execute() {
        light.turnOff()
    }
}

// Step 3: Receiver
class Light {
    fun turnOn() {
        println("Light is ON")
    }

    fun turnOff() {
        println("Light is OFF")
    }
}

// Step 4: Invoker
class RemoteControls {
    private var command: Command? = null

    fun setCommand(command: Command) {
        this.command = command
    }

    fun pressButton() {
        command?.execute()
    }
}

// Step 5: Client code
fun main() {
    val light = Light()
    val turnOnCommand = TurnOnCommand(light)
    val turnOffCommand = TurnOffCommand(light)

    val remote = RemoteControls()

    remote.setCommand(turnOnCommand)
    remote.pressButton()  // Output: Light is ON

    remote.setCommand(turnOffCommand)
    remote.pressButton()  // Output: Light is OFF
}
