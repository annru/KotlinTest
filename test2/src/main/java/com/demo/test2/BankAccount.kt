package com.demo.test2

import kotlin.properties.Delegates

class BankAccount(private var balance: Double) {


    var name: String by Delegates.observable("") { _, oldName, newName ->
        println("名称从${oldName}变成${newName}")
    }

    fun withdraw(amount: Double) {
        check(balance >= amount) { "余额不足" }
        println("不执行了吧")
        balance -= amount


        println("提现成功，余额：$balance")
    }

    fun processCommand(command: String) {
        when (command) {
            "start" -> println("start")
            "stop" -> println("stop")
            "pause" -> println("pause")
            else -> error("undefine this command")
        }
    }

    fun calListTime() {
        val largeList = (1..10_000_000).toList()
        val largeSeq = largeList.asSequence()
        val result1StartTime = System.currentTimeMillis()
        val result1 = largeList.filter { it % 3 == 0 }.map { it * 2 }.take(5)
        val result1EndTime = System.currentTimeMillis()
        println(result1)
        println("不使用序列耗时:${result1EndTime - result1StartTime}")
        val result2StartTime = System.currentTimeMillis()
        val result2 = largeSeq.filter { it % 3 == 0 }.map { it * 2 }.take(5).toList()
        val result2EndTime = System.currentTimeMillis()
        println(result2)
        println("使用序列耗时:${result2EndTime - result2StartTime}")

    }


}

fun main() {
//    typealias BA = BankAccount(100.0)

    val amount = BankAccount(100.0)
//    amount.withdraw(110.0)
//    amount.withdraw(60.0)
//    amount.processCommand("test")
    amount.calListTime()
    amount.name = "我是新的"
}