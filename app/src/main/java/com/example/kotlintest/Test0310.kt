package com.example.kotlintest

class Test0310 {}

interface A {
    fun funA()
}

interface B {
    fun funB()
}

abstract class Man {
    abstract fun findMan()
}

fun main() {
    val item = object : Man(), A, B {
        override fun funA() {
            TODO("Not yet implemented")
        }

        override fun funB() {
            TODO("Not yet implemented")
        }

        override fun findMan() {
            TODO("Not yet implemented")
        }

    }
}