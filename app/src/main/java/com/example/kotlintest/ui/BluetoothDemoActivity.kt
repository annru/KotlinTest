package com.example.kotlintest.ui

import android.Manifest
import android.annotation.SuppressLint
import android.bluetooth.BluetoothAdapter
import android.bluetooth.BluetoothManager
import android.bluetooth.le.ScanCallback
import android.bluetooth.le.ScanFilter
import android.bluetooth.le.ScanResult
import android.bluetooth.le.ScanSettings
import android.content.pm.PackageManager
import android.os.Bundle
import androidx.core.app.ActivityCompat
import com.alibaba.android.arouter.facade.annotation.Route
import com.example.kotlintest.ArouterPath
import com.example.kotlintest.R
import com.example.kotlintest.databinding.ActivityBluetoothDemoBinding
import com.orhanobut.logger.Logger

@Route(path = ArouterPath.BluetoothDemoActivity)
class BluetoothDemoActivity : BaseActivity<ActivityBluetoothDemoBinding>() {

    private lateinit var bluetoothManager: BluetoothManager
    private lateinit var bluetoothAdapter: BluetoothAdapter


    override fun setContentView(): Int = R.layout.activity_bluetooth_demo


    private val scanCallBack = object : ScanCallback() {

        @SuppressLint("MissingPermission")
        override fun onScanResult(callbackType: Int, result: ScanResult) {
            super.onScanResult(callbackType, result)
            val device = result.device
            val deviceName = device?.name ?: "Unknown"
            val deviceAddress = device?.address
            val rssi = result.rssi

            Logger.i("发现BLE设备: 名称 - $deviceName, 地址 - $deviceAddress, 信号强度 - $rssi")
        }

        override fun onBatchScanResults(results: MutableList<ScanResult>?) {
            super.onBatchScanResults(results)
        }

        override fun onScanFailed(errorCode: Int) {
            super.onScanFailed(errorCode)
            Logger.i("扫描失败---错误Code:$errorCode")
        }
    }

    override fun init(bundle: Bundle?) {
        Logger.i("初始化")
//        bluetoothManager = getSystemService(Context.BLUETOOTH_SERVICE) as BluetoothManager
//        bluetoothAdapter = bluetoothManager.adapter
//        //检查蓝牙是否可用
//        if (!bluetoothAdapter.isEnabled) {
//            Logger.i("蓝牙不可用")
//            return
//        }
//        startBleScan()
    }

    private fun startBleScan() {
        Logger.i("开始扫描......")
        val settings =
            ScanSettings.Builder().setScanMode(ScanSettings.SCAN_MODE_LOW_LATENCY) // 或选择其他适合的扫描模式
                .build()

        val filters = mutableListOf<ScanFilter>() // 可以添加过滤条件，如特定的服务UUID等

        if (ActivityCompat.checkSelfPermission(
                this, Manifest.permission.BLUETOOTH_SCAN
            ) != PackageManager.PERMISSION_GRANTED
        ) {
            Logger.i("请打开蓝牙")
            return
        }
        bluetoothAdapter.bluetoothLeScanner.startScan(filters, settings, scanCallBack)
    }

    @SuppressLint("MissingPermission")
    fun stopBleScan() {
        bluetoothAdapter.bluetoothLeScanner.stopScan(scanCallBack)
    }
}
