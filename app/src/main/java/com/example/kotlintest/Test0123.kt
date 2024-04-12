package com.example.kotlintest

import java.lang.Thread.sleep

class Test0123 {

    @Synchronized
    fun threadLock(s: String) {
        println("${System.currentTimeMillis()} ：$s")
        sleep(5000)
    }
}

fun main() {
//    val test = Test0123()
//    Thread { }.start()
//
//    Thread {
//        test.threadLock("first thread")
//    }.start()
//
//    Thread {
//        test.threadLock("second thread")
//    }.start()
    println(highFunTest(30, 20, ::plusFun))
    println(highFunTest(30, 20, ::minusFun))


    val plusResult = highFunTest(30, 20) { n1: Int, n2: Int ->
        n1 + n2
    }
    println(plusResult)

    val minusResult = highFunTest(30, 20) { n1: Int, n2: Int ->
        n1 - n2
    }
    println(minusResult)
}

fun highFunTest(num1: Int, num2: Int, block: (Int, Int) -> Int): Int {
    return block(num1, num2)
}


fun plusFun(num1: Int, num2: Int): Int = num1 + num2

fun minusFun(num1: Int, num2: Int): Int = num1 - num2
