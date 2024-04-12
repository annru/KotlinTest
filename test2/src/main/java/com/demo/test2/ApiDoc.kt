package com.demo.test2


@Target(AnnotationTarget.CLASS)
annotation class ApiDoc(val value:String)

@ApiDoc("修饰类")
class Box{

    val size = 5
}
