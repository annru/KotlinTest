package com.example.kotlintest.recyclerview

interface ItemTouchCallback {
    fun onItemMove(fromPosition: Int, toPosition: Int): Boolean

    fun onItemRemove(position: Int)
}