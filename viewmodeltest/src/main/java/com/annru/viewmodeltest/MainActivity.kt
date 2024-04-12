package com.annru.viewmodeltest

import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import java.util.logging.Logger

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        val viewModel = ViewModelProvider(this)[TestViewModel::class.java]


        val countTv = findViewById<TextView>(R.id.countTv)


        val addBtn = findViewById<Button>(R.id.addBtn)


        addBtn.setOnClickListener {
            viewModel.addCount()
        }

        viewModel.countLiveData.observe(this) {
            countTv.text = it.toString()
        }

    }


    override fun onResume() {
        super.onResume()
        Log.i("MainActivity", "onResume")
    }

    override fun onStop() {
        super.onStop()
        Log.i("MainActivity", "onStop")
    }
}