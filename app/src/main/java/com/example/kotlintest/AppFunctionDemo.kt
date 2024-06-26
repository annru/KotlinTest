package com.example.kotlintest

/**
 * 功能模块列表
 */
sealed class AppFunctionDemo(val name: String) {
    data object BluetoothDemo : AppFunctionDemo("蓝牙")
    data object RecyclerViewDemo : AppFunctionDemo("RecyclerViewDemo")
    data object PhotoPermissionDemo : AppFunctionDemo("选择性照片和视频访问授权")


    companion object {
        fun getFunctionsList(): MutableList<String> {
            val list = mutableListOf<String>()

            //遍历密封类的子类
            AppFunctionDemo::class.sealedSubclasses.forEach {
                it.objectInstance?.name?.let { name ->
                    list.add(name)
                }
            }
            return list
        }
    }
}
