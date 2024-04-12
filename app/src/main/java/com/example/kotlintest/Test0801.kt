package com.example.kotlintest

import kotlinx.coroutines.*

class Test0801 {

    @OptIn(DelicateCoroutinesApi::class)
    suspend fun aa() {
        runBlocking {

        }

        GlobalScope.launch(Dispatchers.IO) {

        }

        val der: Deferred<String> = GlobalScope.async {
            return@async ""
        }
    }

    suspend fun  tt(){}


}

fun main() {

//    val student = Student("an", 30)
    val student = StudentNew("aa", 31)
    val (name, age) = student
    println(name)
    println(age)
    println(student.aa)
}

//顶层函数
fun topFunction(): String = if (System.currentTimeMillis() > 2) "aa" else "bb"


data class Student(val a: String, val b: Int) {
    var name: String = a
    var age: Int = b
}

class StudentNew(val aa: String, val bb: Int) {
    operator fun component1(): String {
        return aa
    }

    operator fun component2(): Int {
        return bb
    }
}