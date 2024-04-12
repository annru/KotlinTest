package com.example.kotlintest

class Benz(val name: String) : ICar {

    override fun run() {
        println("${name}汽车跑起来了")
    }
}