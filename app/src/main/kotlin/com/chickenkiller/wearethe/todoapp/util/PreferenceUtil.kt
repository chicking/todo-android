package com.chickenkiller.wearethe.todoapp.util

import android.content.Context
import android.content.SharedPreferences

/**
 * Created by spadeworker on 2017. 9. 17..
 */

class PreferenceUtil {
    companion object {

        private val PREF_ACCESS_TOKEN = "ACCESS_TOKEN"

        var pref: SharedPreferences? = null

        fun init(context: Context) {
            pref = context.getSharedPreferences("pref", Context.MODE_PRIVATE)
        }

        fun setAuthToken(token: String) = pref?.edit()?.putString(PREF_ACCESS_TOKEN, token)?.apply()

        fun getAuthToken(): String? {
            var token = pref?.let { it.getString(PREF_ACCESS_TOKEN, "") } ?: ""
            return if (token.isNotEmpty()) "Bearer:" + token else null
        }
    }
}