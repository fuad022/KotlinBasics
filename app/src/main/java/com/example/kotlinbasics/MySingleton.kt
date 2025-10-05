package com.example.kotlinbasics

class MySingleton private constructor() {
    // Initialize any properties or methods here

    companion object {
        @Volatile
        private var instance: MySingleton? = null

        fun getInstance(): MySingleton {
            return instance ?: synchronized(this) {
                instance ?: MySingleton().also {
                    instance = it
                }
            }
        }
    }
}