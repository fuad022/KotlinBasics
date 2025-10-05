package com.example.kotlinbasics

fun main() {
    val bulb = LightBulbDIP()
    val switch = LightSwitchDIP(bulb)

    switch.operate()
}

interface SwitchableDIP {
    fun turnOn()
    fun turnOff()
}

class LightBulbDIP : SwitchableDIP {
    override fun turnOn() {
        println("Лампочка включена")
    }

    override fun turnOff() {
        println("Лампочка выключена")
    }
}

class LightSwitchDIP(private val device: SwitchableDIP) {
    fun operate() {
        if (device != null) {
            device.turnOn()
        } else {
            device.turnOff()
        }
    }
}