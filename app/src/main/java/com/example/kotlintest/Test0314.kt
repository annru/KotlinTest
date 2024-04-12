package com.example.kotlintest

class Test0314 {
    var name: String = "azx"


    private val _arr = mutableListOf<String>()

    val list: MutableList<String>
        get() = _arr


    fun test() {
        val str = topFunctions()
        list[0]
    }

}

@Deprecated(
    "use Calculator3 instead", ReplaceWith("Calculator3"), DeprecationLevel.WARNING
)
class Calculator {
    fun add(a: Int, b: Int) = a - b
}

class Calculator3 {
    fun add(a: Int, b: Int) = a + b
}


fun main() {
    val calculator = Calculator()
    val result = calculator.add(1, 2)
    println(result)

}