package com.example.kotlintest.workmanager

import android.content.Context
import androidx.work.Data
import androidx.work.Worker
import androidx.work.WorkerParameters

class TestWork(context: Context, workerParams: WorkerParameters) : Worker(context, workerParams) {


    override fun doWork(): Result {
        doSomething()
        val resultData = Data.Builder().putInt("age", 99).putString("name", "回礼").build()
        return Result.success(resultData)
    }

    private fun doSomething() {
        println("TestWork在执行doWork...")

        val data = inputData
        println("age==${data.getInt("age", 0)}")
        println("name==${data.getString("name")}")


    }
}