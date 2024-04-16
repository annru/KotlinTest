package com.example.kotlintest.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import com.orhanobut.logger.Logger

abstract class BaseActivity<T : ViewDataBinding> : AppCompatActivity() {
    val viewBinding: T by lazy { DataBindingUtil.setContentView<T>(this, setContentView()) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        init(savedInstanceState)
    }

    abstract fun setContentView(): Int

    abstract fun init(bundle: Bundle?)
}