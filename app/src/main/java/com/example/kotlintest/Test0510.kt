package com.example.kotlintest

import kotlinx.coroutines.*

class Test0510 {}

fun main() = runBlocking {
    val job = launch(Dispatchers.IO) {
        var i = 0
        while (isActive) {
            Thread.sleep(500L)
            i++
            println("i==$i")
        }
    }
    delay(2000L)
    job.cancel()
    job.join()
    println("end")
}


fun topFunctions(): String {
    println("这是一个顶层函数")
    return "这是一个顶层函数"
}