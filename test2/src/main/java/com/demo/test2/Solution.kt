package com.demo.test2

class Solution {
    fun wordBreak(s: String, wordDict: List<String>): Boolean {
        var temp = s
        wordDict.forEach {
            if (temp.contains(it)) {
                temp = temp.replace(it, "")
            }
        }
        return temp.isEmpty()
    }
}

fun main() {
    val solution = Solution()
   println(solution.wordBreak("appleorangepen", listOf("apple", "orange", "pen")))
}