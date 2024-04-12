package com.annru.viewmodeltest

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class TestViewModel : ViewModel() {

    val countLiveData = MutableLiveData<Int>()

    var count = 0


    fun addCount() {
        count++
        countLiveData.postValue(count)
    }
}