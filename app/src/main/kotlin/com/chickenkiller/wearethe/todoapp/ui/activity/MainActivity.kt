package com.chickenkiller.wearethe.todoapp.ui.activity

import android.os.Bundle
import com.chickenkiller.wearethe.todoapp.R
import com.chickenkiller.wearethe.todoapp.ui.base.BaseActivity
import com.chickenkiller.wearethe.todoapp.util.PreferenceUtil

class MainActivity : BaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        PreferenceUtil.init(this)
    }
}
