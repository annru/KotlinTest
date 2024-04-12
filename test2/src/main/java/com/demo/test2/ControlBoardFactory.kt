package com.demo.test2

abstract class ControlBoardFactory<out T : ControlBoardService> {

    abstract fun createControlBoard(): T
}