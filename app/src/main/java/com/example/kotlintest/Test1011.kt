package com.example.kotlintest

import java.io.File

class Test1011 {


}


fun main() {
    val oldFile = File("E:/testCopyFile/oldPath/oldFile.txt")
    val targetFile = File("E:/testCopyFile/newPath/newFile.txt")


    val newFile = oldFile.copyTo(targetFile, true)
    println("拷贝结果：$newFile")

    val readText = newFile.readText()
    println("读取文本：$readText")


    File("E:/testCopyFile").walk().filter { it.isFile && it.extension == "java" }.forEach {
        println("文件名称---${it.name}")
    }

}

