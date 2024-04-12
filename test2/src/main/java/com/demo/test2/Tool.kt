package com.demo.test2

import android.util.Log
import kotlin.reflect.full.declaredMemberProperties
import kotlin.reflect.full.memberFunctions
import kotlin.reflect.full.memberProperties

class Tool {
    private val tag = "Tool"
    private var name = ""
    var id: Int = 0

    constructor(name: String, id: Int) {
        this.name = name
        this.id = id
    }

    private fun test() {
        Log.i(tag, "test")
    }

    fun study(text: String) {
        Log.i(tag, "study $text")
    }
}

fun main() {
    val kClass = Tool::class
    kClass.declaredMemberProperties.forEach {
        println(it.name)
    }

    kClass.memberProperties.forEach {
        println(it.name)
    }
    println("获取该类和所有超类中声明的非扩展非静态函数")
    kClass.memberFunctions.forEach {

        // 获取该类和所有超类中声明的非扩展非静态函数
        println(it.name)
    }

    println("获取该类中可访问的所有函数和属性，但不包括构造函数。")
    kClass.members.forEach {

        // 获取该类中可访问的所有函数和属性，但不包括构造函数。
        println(it.name)
    }

}

