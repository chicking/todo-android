package com.chickenkiller.wearethe.todoapp.ui.fragment

import android.os.Bundle
import android.support.v4.widget.SwipeRefreshLayout
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.chickenkiller.wearethe.todoapp.R
import com.chickenkiller.wearethe.todoapp.api.ApiManager
import com.chickenkiller.wearethe.todoapp.api.model.TodoList
import com.chickenkiller.wearethe.todoapp.ui.base.BaseFragment
import com.chickenkiller.wearethe.todoapp.ui.list.TodoContentAdapter
import com.chickenkiller.wearethe.todoapp.util.PreferenceUtil
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class TodoListFragment : BaseFragment() {

    var refershLayout: SwipeRefreshLayout? = null
    var todoRecyclerView: RecyclerView? = null
    val todoAdapter: TodoContentAdapter = TodoContentAdapter()

    override fun onCreateView(inflater: LayoutInflater?,
                              container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        var view = inflater?.inflate(R.layout.fragment_todo_list, null)
        view?.let {
            initView(view)
        }

        return view
    }

    fun initView(view: View) {

        refershLayout = view.findViewById(R.id.refresh_layout) as SwipeRefreshLayout
        refershLayout?.let {
            it.setOnRefreshListener {
                requestGetTodoList()
            }
        }
        todoRecyclerView = view.findViewById(R.id.todo_recyclerview) as RecyclerView
        todoRecyclerView?.let {
            it.layoutManager = LinearLayoutManager(activity)
            it.adapter = todoAdapter

            refershLayout?.isRefreshing = true
            requestGetTodoList()

        }
    }

    fun updateData(todoList: TodoList?) {
        todoList?.todos?.let {
            todoAdapter.updateList(it)
        }
    }

    fun requestGetTodoList() {
        val api = ApiManager.getInstance().service.getTodoList(PreferenceUtil.getAuthToken())
        api.enqueue(object : Callback<TodoList> {
            override fun onFailure(call: Call<TodoList>?, t: Throwable?) {
                Log.d("@YJ", t.toString())
                Toast.makeText(activity, "목록 로드 실패!!", Toast.LENGTH_SHORT).show()
                refershLayout?.isRefreshing = false
            }

            override fun onResponse(call: Call<TodoList>?, response: Response<TodoList>?) {
                response?.let {
                    if (response.isSuccessful) {
                        updateData(response.body())
                    } else {
                        Toast.makeText(activity, "목록 로드 실패!!", Toast.LENGTH_SHORT).show()
                    }
                } ?: Toast.makeText(activity, "목록 로드 실패!!", Toast.LENGTH_SHORT).show()

                refershLayout?.isRefreshing = false
            }
        })
    }


}