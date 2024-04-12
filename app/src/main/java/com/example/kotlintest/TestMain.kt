package com.example.kotlintest

import com.example.kotlintest.bean.Color
import com.orhanobut.logger.Logger
import org.jetbrains.annotations.TestOnly

class TestMain {}

lateinit var fib: (Int) -> Long


//高层模块
fun main() {
//    val xiaoming = Driver()
//    val benz = Benz("奔驰")
//    val bwn = BWM()
//    xiaoming.driver(benz)
//    xiaoming.driver(bwn)
    findlastmement()


//    fib = { n: Int ->
//        when (n) {
//            0, 1 -> 1L
//            else -> fib(n - 1) + fib(n - 2)
//        }
//    }.memoize()

    val a = CompareInfo("a", 12)
    val b = CompareInfo("a", 12)
    println("result====${a == b}")

    findColor()


    val age = -1
//    require(age > 0) { "age must 大于 0" }

//    val name:String? = null
//    checkNotNull(name){"name must not null"}

    val target:String = ""
    val result = target.ifEmpty { "哈哈" }
    println(result)

    println("抛异常后面的还执行吗")
}

fun <T, R> ((T) -> R).memoize(): ((T) -> R) {
    val original = this
    val cache = mutableMapOf<T, R>()
    return { n: T -> cache.getOrPut(n) { original(n) } }
}

fun findlastmement() {
    val members = listOf(1, 2, 3)
    println(members.last())
}

fun findColor() {
    val colorBean = findByRgb("#FF7F000")
    println("找到了颜色对象吗？----${colorBean?.colorName}")
}


@OptIn(ExperimentalStdlibApi::class)
fun findByRgb(rgb: String): Color? = Color.entries.find { it.rgb == rgb }






