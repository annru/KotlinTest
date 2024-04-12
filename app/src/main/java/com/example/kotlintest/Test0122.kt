package com.example.kotlintest

class Test0122 {


    fun removeDuplicates(nums: IntArray): Int {
        var slow = 1
        for (fast in 1 until nums.size) {
            if (nums[fast] != nums[fast - 1]) {
                nums[slow++] = nums[fast]
            }
        }
        return slow
    }

    fun removeElement(nums: IntArray, value: Int): Int {
        var slow = 1
        for (fast in 1 until nums.size) {
            if (nums[fast] != value) {
                nums[slow++] = nums[fast]
            }
        }
        return slow
    }

    fun sort(nums: IntArray): Unit {
        var s = 0
        for (i in nums.indices){
            if(nums[i] != 0){
                nums[s++] = nums[i]
            }
        }
        for (m in s until nums.size){
            nums[m]=0
        }
        nums.forEach {
            print("$it ")
        }
    }

    fun findIndex(b:String,a:String): Int {
        return b.indexOf(a)
    }

}


fun main() {
    val nums = intArrayOf(0, 1, 1, 1, 3, 6, 7, 10, 9)
//    println(Test0122().removeDuplicates(nums))
//    println(Test0122().removeElement(nums, 1))
    println(Test0122().findIndex("addasad","as"))
//    Test0122().sort(nums)
}