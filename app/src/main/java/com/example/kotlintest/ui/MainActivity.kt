package com.example.kotlintest.ui

import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.alibaba.android.arouter.facade.annotation.Route
import com.alibaba.android.arouter.launcher.ARouter
import com.example.kotlintest.AppFunctionDemo
import com.example.kotlintest.ArouterPath
import com.example.kotlintest.BannerAdapter
import com.example.kotlintest.R
import com.example.kotlintest.databinding.ActivityMainBinding

@Route(path = ArouterPath.MainActivity)
class MainActivity : BaseActivity<ActivityMainBinding>() {


    override fun setContentView(): Int = R.layout.activity_main

    private val bannerAdapter = BannerAdapter {
        val routerPath: String = when (it) {
            AppFunctionDemo.BluetoothDemo.name -> ArouterPath.BluetoothDemoActivity

            AppFunctionDemo.PhotoPermissionDemo.name -> ArouterPath.PhotoPermissionDemoActivity

            AppFunctionDemo.RecyclerViewDemo.name -> ArouterPath.RecyclerViewDemoActivity


            else -> {
                ""
            }
        }
        ARouter.getInstance().build(routerPath).navigation()
    }

    val data = AppFunctionDemo.getFunctionsList()

    override fun init(bundle: Bundle?) {
        viewBinding.banner.layoutManager = LinearLayoutManager(this)
        bannerAdapter.submitList(data)
        viewBinding.banner.adapter = bannerAdapter
    }


}
