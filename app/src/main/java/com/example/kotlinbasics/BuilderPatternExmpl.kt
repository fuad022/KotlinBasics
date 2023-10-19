package com.example.kotlinbasics

fun main() {
    val person = PersonClass.Builder()
        .setFirstName("John")
        .setLastName("Doe")
        .setAge(30)
        .setAddress("123 Main Street")
        .build()

    println("First Name: ${person.firstName}")
    println("Last Name: ${person.lastName}")
    println("Age: ${person.age}")
    println("Address: ${person.address}")
}

class PersonClass private constructor(
    val firstName: String?,
    val lastName: String?,
    val age: Int,
    val address: String?
) {
    class Builder {
        private var firstName: String? = null
        private var lastName: String? = null
        private var age: Int = 0
        private var address: String? = null

        fun setFirstName(firstName: String): Builder {
            this.firstName = firstName
            return this
        }

        fun setLastName(lastName: String): Builder {
            this.lastName = lastName
            return this
        }

        fun setAge(age: Int): Builder {
            this.age = age
            return this
        }

        fun setAddress(address: String): Builder {
            this.address = address
            return this
        }

        fun build(): PersonClass {
            return PersonClass(firstName, lastName, age, address)
        }
    }
}