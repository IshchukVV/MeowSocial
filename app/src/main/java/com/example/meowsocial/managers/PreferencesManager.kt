package com.example.meowsocial.managers

import android.content.Context
import android.content.SharedPreferences
import com.example.meowsocial.MeowSocialApp

class PreferencesManager() {

    //TODO: DI
    private val context = MeowSocialApp.app.applicationContext

    private val sharedPreferences: SharedPreferences =
        context.getSharedPreferences(PREFERENCES_FILE_NAME, Context.MODE_PRIVATE)


    fun putString(key: String, value: String?) {
        sharedPreferences.edit().apply {
            putString(key, value)
            apply()
        }
    }

    fun getString(key: String, defaultValue: String?): String? {
        return sharedPreferences.getString(key, defaultValue)
    }

    fun removeKey(key: String): Boolean {
        return sharedPreferences.edit().remove(key).commit()
    }

    fun contains(key: String): Boolean {
        return sharedPreferences.contains(key)
    }

    companion object {
        private const val PREFERENCES_FILE_NAME = "rossapp_prefs"
    }
}
