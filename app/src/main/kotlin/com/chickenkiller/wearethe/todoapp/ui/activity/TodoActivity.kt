package com.chickenkiller.wearethe.todoapp.ui.activity

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.design.widget.NavigationView
import android.support.v4.widget.DrawerLayout
import android.support.v7.widget.Toolbar
import android.view.MenuItem

import com.chickenkiller.wearethe.todoapp.R
import com.chickenkiller.wearethe.todoapp.ui.fragment.TodoListFragment
import android.support.v4.view.GravityCompat



class TodoActivity : AppCompatActivity() {

    var drawerLayout : DrawerLayout? = null
    var navigationView : NavigationView? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_todo)

        drawerLayout = findViewById(R.id.root_layout) as DrawerLayout
        navigationView = findViewById(R.id.todo_navigationview) as NavigationView
        val toolbar = findViewById(R.id.toolbar) as Toolbar
        setSupportActionBar(toolbar)

        supportActionBar?.let {
            it.setHomeAsUpIndicator(R.drawable.ic_menu)
            it.setDisplayHomeAsUpEnabled(true)
        }



        showTodoListFragment()
    }

    override fun onOptionsItemSelected(item: MenuItem?): Boolean {

        item?.let {
            when (item.itemId) {
                android.R.id.home -> {
                    drawerLayout?.let {
                        it.openDrawer(GravityCompat.START)
                        return true
                    }
                }
                else -> {
                    // do nothing
                }
            }
        }

        return super.onOptionsItemSelected(item)
    }

    fun showTodoListFragment() {
        supportFragmentManager.beginTransaction()
                .replace(R.id.content, TodoListFragment()).commit()
    }
}
