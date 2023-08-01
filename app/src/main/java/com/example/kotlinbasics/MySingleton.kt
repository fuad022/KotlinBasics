package com.example.kotlinbasics

class MySingleton private constructor(private val param: String) {
    companion object {
        @Volatile
        private var instance: MySingleton? = null

        fun getInstance(param: String): MySingleton {
            return instance ?: synchronized(this) {
                instance ?: MySingleton(param).also {
                    instance = it
                }
            }
        }
    }
}