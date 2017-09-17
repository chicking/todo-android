package com.chickenkiller.wearethe.todoapp

import android.app.Application
import com.chickenkiller.wearethe.todoapp.util.PreferenceUtil

/**
 * Created by spadeworker on 2017. 9. 17..
 */

class TodoApp : Application() {
    override fun onCreate() {
        super.onCreate()

        PreferenceUtil.init(this)
    }
}