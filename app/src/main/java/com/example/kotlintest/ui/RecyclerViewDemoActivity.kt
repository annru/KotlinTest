package com.example.kotlintest.ui

import android.os.Bundle
import com.alibaba.android.arouter.facade.annotation.Route
import com.alibaba.android.arouter.launcher.ARouter
import com.example.kotlintest.ArouterPath
import com.example.kotlintest.R
import com.example.kotlintest.databinding.ActivityRecyclerviewDemoBinding


@Route(path = ArouterPath.RecyclerViewDemoActivity)
class RecyclerViewDemoActivity : BaseActivity<ActivityRecyclerviewDemoBinding>() {

    override fun setContentView(): Int =R.layout.activity_recyclerview_demo

    override fun init(bundle: Bundle?) {
        viewBinding.dragViewBtn.setOnClickListener {
            ARouter.getInstance().build(ArouterPath.RecyclerViewDragActivity).navigation()
        }

    }

}