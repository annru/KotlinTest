package com.example.kotlintest

class Test0307 {

    val data: String by lazy {
        request()
    }

    private fun request(): String {
        println("执行网络请求")
        return "网络数据"
    }


    fun test() {
        val str = "Kotlin is my favorite language. I love Kotlin!"

        //1.清洗
        val cleanStr = clean(str)

        val words = cleanStr.split(" ")


        //2.词频统计
        val map = getWordCount(words)


        //3.
        val list = sortByFrequency(map)

        print(list)
    }

    fun test2() {
        val str = "Kotlin is my favorite language. I love Kotlin!"
        val list = str.clean().split(" ").getWordCount().mapToList { WordFreq(it.key, it.value) }
            .sortedByDescending { it.count }
        print(list)
    }


    private fun clean(text: String): String {
        return text.replace("[^A-Za-z]".toRegex(), " ").trim()
    }

    private fun getWordCount(list: List<String>): Map<String, Int> {
        val map = hashMapOf<String, Int>()
        for (word in list) {
            if (word == "") continue
            val trim = word.trim()
            val count = map.getOrDefault(trim, 0)
            map[trim] = count + 1
        }
        return map
    }

    private fun sortByFrequency(map: Map<String, Int>): MutableList<WordFreq> {
        val list = mutableListOf<WordFreq>()
        for (entry in map) {
            if (entry.key == "") continue
            val freq = WordFreq(entry.key, entry.value)
            list.add(freq)
        }
        list.sortedByDescending { it.count }
        return list
    }

    fun main() {
//    val t = Test0307()
//    t.test2()
        println("开始")
        println(data)
        println(data)
    }


}

fun main() {
    val t = Test0307()
    t.main()
}

