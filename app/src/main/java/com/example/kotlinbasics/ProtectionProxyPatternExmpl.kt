package com.example.kotlinbasics

fun main() {
    // Создаем реальный ресурс
    val realResource = RealResource()

    // Создаем защитный прокси с разрешенным доступом
    val proxyWithAccess = ProtectionProxy(realResource, accessGranted = true)
    println(proxyWithAccess.access()) // Реальный ресурс: доступ разрешен

    // Создаем защитный прокси с запрещенным доступом
    val proxyWithoutAccess = ProtectionProxy(realResource, accessGranted = false)
    println(proxyWithoutAccess.access()) // Защищенный ресурс: доступ запрещен
}

// Интерфейс, представляющий общий доступ к ресурсу
interface Resource {
    fun access(): String
}

// Реальная реализация ресурса
class RealResource : Resource {
    override fun access(): String {
        return "Реальный ресурс: доступ разрешен"
    }
}

// Защитный прокси, контролирующий доступ к ресурсу
class ProtectionProxy(
    private val realResource: RealResource,
    private val accessGranted: Boolean
) : Resource {
    override fun access(): String {
        return if (accessGranted) {
            realResource.access()
        } else {
            "Защищенный ресурс: доступ запрещен"
        }
    }
}