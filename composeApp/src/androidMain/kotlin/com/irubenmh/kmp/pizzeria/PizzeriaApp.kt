package com.irubenmh.kmp.pizzeria

import android.app.Application
import com.irubenmh.kmp.pizzeria.di.initKoin
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger

class PizzeriaApp : Application()  {

    override fun onCreate() {
        super.onCreate()
        initKoin {
            androidLogger()
            androidContext(this@PizzeriaApp)
        }
    }
}