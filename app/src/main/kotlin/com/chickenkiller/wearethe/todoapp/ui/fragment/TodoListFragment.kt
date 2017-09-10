package com.chickenkiller.wearethe.todoapp.ui.fragment

import android.os.Bundle
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.chickenkiller.wearethe.todoapp.R
import com.chickenkiller.wearethe.todoapp.ui.base.BaseFragment

class TodoListFragment : BaseFragment() {

    var todoRecyclerView: RecyclerView? = null

    override fun onCreateView(inflater: LayoutInflater?,
                              container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        var view = inflater?.inflate(R.layout.fragment_todo_list, null)
        view?.let {
            todoRecyclerView = view.findViewById(R.id.todo_recyclerview) as RecyclerView
        }

        return view
    }


}