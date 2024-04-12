package com.demo.test2


@Deprecated("use CalculatorV2 instead.", ReplaceWith("CalculatorV2"), DeprecationLevel.ERROR)
class Calculator {
    fun ada(a: Int, b: Int): Int = a + b
}


class CalculatorV2 {
    fun add(a: Int, b: Int): Int = a + b
}

fun main() {
      val student = Student("Tom", 99.5, 170)
    val school = School("PKU", "Beijing...")
    readMembers(student)
    readMembers(school)}
  fun readMembers(obj: Any) {    // 读取obj的所有成员属性的名称和值}
}

data class Student(    val name: String,    val score: Double,    val height: Int)
data class School(    val name: String,    var address: String)