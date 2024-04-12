package com.sh.flowtest

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.flowOf
import kotlinx.coroutines.flow.zip
import kotlinx.coroutines.launch
import java.util.Scanner

class MainActivity : AppCompatActivity() {

//    private val mainViewModel = ViewModelProvider(this)[MainViewModel::class.java]

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


//        val time = findViewById<TextView>(R.id.timeTv)
        val start = findViewById<Button>(R.id.startBtn)

        val flowInt = flowOf(1, 2, 3)
        val flowString = flowOf("A", "B", "C")
        start.setOnClickListener {
            lifecycleScope.launch {
//                mainViewModel.timeFlow.collect {
                    flowInt.zip(flowString) { intValue, stringValue ->
                        "$intValue$stringValue"
                    }.collect {
                        println("----$it")
                    }
//                }
            }
        }
//        testException()
    }


    private fun testException() {
        val n = "0"
        if (n == "0") {
            throw ArithmeticException("by zero")
        }
    }
}