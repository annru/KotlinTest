package com.sh.flowtest

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.flow

class MainViewModel : ViewModel() {


    val timeFlow = flow {

        var time = 0
        while (true) {
            emit(time)
            kotlinx.coroutines.delay(1000)
            time++
        }
    }
}