package com.example.kotlinbasics

fun main() {
    val contacts = listOf(
        Contact("Icardi", "+9199XXX11111", true),
        Contact("Messi", "+9199XXX22222", false),
        Contact("Ronaldo", "+9199XXX33333", true)
    )

    // Пример 1: Создание Map.
    val nameToNumberMap = contacts.associateBy({ it.name }, { it.phoneNumber })
    println(nameToNumberMap)
    // Вывод: {Icardi=+9199XXX11111, Messi=+9199XXX22222, Ronaldo=+9199XXX33333}

    // Пример 2: Создание Map с ключами, основанными на поле name
    val contactsByName = contacts.associateBy { it.name }
    println(contactsByName)
    // Вывод: {Icardi=Contact(name=Icardi, phoneNumber=+9199XXX11111), Messi=Contact(name=Messi, phoneNumber=+9199XXX22222), Ronaldo=Contact(name=Ronaldo, phoneNumber=+9199XXX33333)}

    // Пример 3: Создание Map с ключами, основанными на поле phoneNumber, значениями являются имена
    val contactsByNumber = contacts.associateBy { it.phoneNumber }
    println(contactsByNumber)
    // Вывод: {+9199XXX11111=Contact(name=Icardi, phoneNumber=+9199XXX11111), +9199XXX22222=Contact(name=Messi, phoneNumber=+9199XXX22222), +9199XXX33333=Contact(name=Ronaldo, phoneNumber=+9199XXX33333)}

    val (mentors, notMentors) = contacts.partition { it.isMentor }
    println(mentors) // [Contact(name=Icardi, phoneNumber=+9199XXX11111, isMentor=true), Contact(name=Ronaldo, phoneNumber=+9199XXX33333, isMentor=true)]
    println(notMentors) // [Contact(name=Messi, phoneNumber=+9199XXX22222, isMentor=false)]
}

data class Contact(val name: String, val phoneNumber: String, val isMentor: Boolean)