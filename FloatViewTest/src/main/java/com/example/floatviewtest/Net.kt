package com.example.floatviewtest

import okhttp3.OkHttpClient
import okhttp3.Request
import okhttp3.Response
import java.util.concurrent.TimeUnit

class Net {

    private val okHttpClient = OkHttpClient.Builder().connectTimeout(10, TimeUnit.SECONDS).build()


    fun run(url: String): String? {
        val request = Request.Builder().url(url).addHeader("Content-Type", "application/json")
            .addHeader("mid", "id3e39e0e9-171e-49f4-a9a4-fc4b3261b45b").addHeader("appVer", "1.0.1")
            .addHeader("appType", "Android").build()
        return try {
            val response: Response = okHttpClient.newCall(request).execute()
            response.body?.string()
        } catch (e: Exception) {
            println("e=======${e.message}")
            "请求异常"
        }
    }
}