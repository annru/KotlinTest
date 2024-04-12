package com.example.kotlintest

import kotlinx.coroutines.*

class Test0420 {
}

fun main(){
    runBlocking {
        println(Thread.currentThread().name)

        launch {
            println(Thread.currentThread().name)
            delay(100L)
        }

        withContext(Dispatchers.IO) {
            Thread.sleep(1000L)
        }
    }
}