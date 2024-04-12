package com.example.floatviewtest

import android.os.Bundle
import android.widget.FrameLayout
import com.annru.viewmodeltest.Apple
import com.example.floatviewtest.databinding.ActivityMainBinding
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MainActivity : BaseActivity<ActivityMainBinding>() {

    override fun setContentView(): Int {
        return R.layout.activity_main
    }

    override fun init(bundle: Bundle?) {
        initView()
    }

    private fun initView() {
        viewBinding.addBtn.setOnClickListener {
            val contentView =
                this.window.decorView.findViewById(android.R.id.content) as FrameLayout
            contentView.addView(FloatView(this))
        }
        getRequest()

    }


    private fun getRequest() {
        val net = Net()
        var str: String? = ""
        CoroutineScope(Dispatchers.IO).launch {
//            str = net.run("http://192.168.0.245:9188/app/shuttle-bus/list")
            str = net.run("https://github.com")
//            str = net.run("https://raw.githubusercontent.com/square/okhttp/master/README.md")
            println("打印请求结果====$str")
            println()
        }
    }

    private fun getMap() {
        val key = listOf("key1", "key2", "key3")
        val value = listOf("value1", "value2", "value3")

        val map = mutableMapOf<String, String>()
        for (i in key.indices) {
            map[key[i]] to value[i]
        }
        map.toMap()

    }
}