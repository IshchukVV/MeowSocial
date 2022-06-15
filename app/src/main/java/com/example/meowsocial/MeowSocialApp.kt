package com.example.meowsocial

import android.app.Application

class MeowSocialApp: Application() {

    companion object {
        lateinit var app: MeowSocialApp
            private set
    }

    override fun onCreate() {
        super.onCreate()
        app = this
    }
}