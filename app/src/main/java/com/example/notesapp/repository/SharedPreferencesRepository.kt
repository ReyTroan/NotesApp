package com.example.notesapp.repository

import android.content.Context
import androidx.core.content.edit

private const val SHARED_PREF_FILE = "shared_Pref"
private const val IS_APP_OPEN = "isAppOpen"

class SharedPreferencesRepository(private val context: Context) {

    private val preferences = context.getSharedPreferences(SHARED_PREF_FILE, Context.MODE_PRIVATE)

    fun isAppOpen(): Boolean {
        return preferences.getBoolean(IS_APP_OPEN, false)
    }

    fun setAppOpen() {
        preferences.edit {
         putBoolean(IS_APP_OPEN, false)
        }
    }
}