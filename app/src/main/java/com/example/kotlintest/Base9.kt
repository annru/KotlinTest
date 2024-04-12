package com.example.kotlintest

object Base9 {


    class Student {
        var name: String? = null
        var age: Int = 0
    }

    fun test() {
        var student = Student().apply {
            name = "aaa"
            age = 30
        }
        getStudentInfo(student)
    }

    fun getStudentInfo(student: Student) {

    }


}

val datas = intArrayOf(1, 5, 9, 3)


val f: (Int, Int) -> Int = ::sum


fun sum(a: Int, b: Int): Int {
    return a + b
}


fun test() {
    print(f(1, 2))
    print(f.invoke(2, 3))
    print((::sum)(2, 5))
    print((::sum).invoke(4, 6))

}


private fun filterApple(
    appleList: List<AppleBean>,
    predicate: (AppleBean) -> Boolean
): List<AppleBean> {
    val destination = mutableListOf<AppleBean>()
    for (apple in appleList) {
        if (predicate(apple)) {
            destination.add(apple)
        }
    }
    println("结果:$destination")
    return destination
}

private val appleList = mutableListOf(
    AppleBean(0xFF0001, 10),
    AppleBean(0xFF0000, 4),
    AppleBean(0xFF0000, 9)
)

private fun filterColorApple(appleBean: AppleBean): Boolean = appleBean.color == 0xFF0000
private fun filterWeightApple(appleBean: AppleBean): Boolean = appleBean.weight > 6
private fun filterWeightColorApple(appleBean: AppleBean): Boolean =
    appleBean.weight > 6 && appleBean.color == 0xFF0000

fun main() {

//    filterApple(appleList, ::filterColorApple)
//    filterApple(appleList, ::filterWeightApple)
//    filterApple(appleList, ::filterWeightColorApple)

//    filterApple(appleList) {
//        it.color == 0xFF0000
//    }
//
//    filterApple(appleList) {
//        it.weight > 6
//    }
//
//    filterApple(appleList) {
//        it.color == 0xFF0000 && it.weight > 6
//    }

    testRemoveList2.removeT {
        it >= 7
    }

    println("结果======$testRemoveList2")


}

inline fun <T> MutableList<T>.removeT(block: (T) -> Boolean): MutableList<T> {
    val map: MutableMap<String, String> = mutableMapOf()
    val iterator = iterator()
    while (iterator.hasNext()) {
        val next = iterator.next()
        if (block(next)) {
            iterator.remove()
        }
    }
//    forEach {
//        if (block(it)) {
//            remove(it)
//        }
//    }
    return this
}

private val testRemoveList2 = mutableListOf(1, 4, 7, 10)


fun te() {
    val list1: MutableList<in String> = mutableListOf()
    list1.add("dffdfd")
}



