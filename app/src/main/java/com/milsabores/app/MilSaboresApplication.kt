package com.milsabores.app

import android.app.Application
import com.milsabores.app.data.remote.SupabaseClient

class MilSaboresApplication : Application() {
    override fun onCreate() {
        super.onCreate()
        SupabaseClient.initialize(this)
    }
}