package com.example.kotlintest

import kotlinx.coroutines.*
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.filter
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.map
import java.lang.IllegalStateException
import kotlin.system.measureTimeMillis

class Test {


    private fun test(block: (x: Int, y: Int) -> Int) {
        val result = block(1, 1)
        println(result)
    }


    fun t() {
        test { x, y -> x + y }
    }
}

//fun main() {
//    runBlocking {
//        val flow = loadData()
//        flow.map {
//            getNewData(it)
//        }.collect {
//            println("i==$it")
//        }
//    }
//}

fun loadData() = flow {
    for (i in 1..6) {
        kotlinx.coroutines.delay(1000)
        emit(i)
    }
}

fun getNewData(value: Int): Int = value * 3


@OptIn(DelicateCoroutinesApi::class)
fun main() {
//    val outer = listOf(1, 2, 3)
//    val inner = listOf(4, 5, 6)
//    run outerSide@{
//        outer.forEach {
//            println("outer=$it")
//            run innerSide@{
//                inner.forEach { it2 ->
//                    print("   inner=$it2")
//                    if (it2 == 5) {
//                        return@outerSide
//                    }
//                }
//            }
//            println("")
//        }
//    }


//    GlobalScope.launch {
//        val time = measureTimeMillis {
//            val sum = withContext(Dispatchers.IO) {
//                val one = async { one() }
//                val two = async { two() }
//                one.await() + two.await()
//            }
//            println("两个方法返回值的和：${sum}")
//        }
//        println("执行耗时：${time}")
//    }
//    println("----------------")
//    /*应为上面的协程代码并不会阻塞掉线程，所以我们这里让线程睡4秒，保证线程的存活，在实际的Android开发中无需这么做*/
//    Thread.sleep(4000)
//    aa()

//    foo()

    OO.foo()
    OO.bar()
}


suspend fun one(): Int {
    delay(1500)
    return 1
}

suspend fun two(): Int {
    delay(1500)
    return 2
}


fun aa() {
    val b = runBlocking {
        coroutineScope {
            val job1 = async {
                delay(1000)
                println("job1 finished")
            }
            val job2 = async {
                delay(500)
                println("job2 finished")
                throw IllegalArgumentException()
            }
        }
    }
}




class OO {
    companion object {
        @JvmStatic
        fun foo() {
        }

        fun bar() {}
    }
}



