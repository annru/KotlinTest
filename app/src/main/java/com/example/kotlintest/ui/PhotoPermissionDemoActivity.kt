package com.example.kotlintest.ui

import android.Manifest.permission.READ_EXTERNAL_STORAGE
import android.Manifest.permission.READ_MEDIA_IMAGES
import android.Manifest.permission.READ_MEDIA_VIDEO
import android.Manifest.permission.READ_MEDIA_VISUAL_USER_SELECTED
import android.os.Build
import android.os.Bundle
import androidx.activity.result.contract.ActivityResultContract
import androidx.activity.result.contract.ActivityResultContracts
import com.alibaba.android.arouter.facade.annotation.Route
import com.example.kotlintest.ArouterPath
import com.example.kotlintest.R
import com.example.kotlintest.databinding.ActivityPhotoPermissionDemoBinding
import com.orhanobut.logger.Logger


/**
 * Android 14新特性
 * 选择性照片和视频访问授权
 */
@Route(path = ArouterPath.PhotoPermissionDemoActivity)
class PhotoPermissionDemoActivity : BaseActivity<ActivityPhotoPermissionDemoBinding>() {


    override fun setContentView(): Int = R.layout.activity_photo_permission_demo


    override fun init(bundle: Bundle?) {
        viewBinding.newTestTv.text = "请求权限"
        viewBinding.newTestTv.setOnClickListener {
            println("请求权限带盐")
            requestPermissions()
        }
    }

    private val permissionLauncher =
        registerForActivityResult(ActivityResultContracts.RequestMultiplePermissions()) {
            //处理权限请求结果
        }

    private fun requestPermissions() {
        Logger.i("请求权限")
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.UPSIDE_DOWN_CAKE) {
            permissionLauncher.launch(
                arrayOf(
                    READ_MEDIA_IMAGES, READ_MEDIA_VIDEO, READ_MEDIA_VISUAL_USER_SELECTED
                )
            )
        } else if (Build.VERSION.SDK_INT == Build.VERSION_CODES.TIRAMISU) {
            permissionLauncher.launch(arrayOf(READ_MEDIA_IMAGES, READ_MEDIA_VIDEO))
        } else {
            permissionLauncher.launch(arrayOf(READ_EXTERNAL_STORAGE))
        }
    }


}
