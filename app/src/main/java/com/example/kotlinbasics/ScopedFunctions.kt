package com.example.kotlinbasics

class ScopedFunctions {
    var name: String = "Abcd"
    var contactNumber: String = "1234567890"
    var address: String = "xyz"

    fun displayInfo() = print("\n Name: $name\n " +
            "Contact Number: $contactNumber\n " +
            "Address: $address")
}

fun main() {
//    performRunOperation()
//    performWithOperation()
//    performApplyOperation()
//    performAlsoOperation()

//    val a = List(8) {
//        it * 2 + 1
//    }
//    println(a)
//    val d = mapOf("apple" to 10, "orange" to 5)

    val arr1 = arrayOf(10, 20, 30)
    val arr2 = arrayOf(100, 200, 300)
    val result = arr1 + arr2
    println(result.toIntArray())
}

private fun performRunOperation() {
    ScopedFunctions().run {
        name = "Asdf"
        contactNumber = "0987654321"
        return@run "${displayInfo()}"
    }
}

private fun performWithOperation() {
    val person = with(ScopedFunctions()) {
        return@with this.name
//        return@with "${displayInfo()}"
    }
    print(person)
}

private fun performApplyOperation() {
    val scopedFunctions: ScopedFunctions? = null
    scopedFunctions?.apply {
        name = "asdf"
        contactNumber = "1234"
        address = "wasd"
        displayInfo()
    }
}

private fun performAlsoOperation() {
    val name = ScopedFunctions().also {
        print("Current name is: ${it.name}\n")
        it.name = "modifiedName"
    }.run {
        "Modified name is: $name\n"
    }
    print(name)
}









