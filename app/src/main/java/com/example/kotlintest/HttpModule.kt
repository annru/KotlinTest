package com.example.kotlintest

import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ApplicationComponent

@InstallIn(ApplicationComponent::class)
@Module
class HttpModule {

    fun getHttpObject(): HttpObject {
        return HttpObject()
    }
}



