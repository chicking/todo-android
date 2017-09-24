package com.chickenkiller.wearethe.todoapp.ui.list

import android.support.v7.widget.RecyclerView
import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import com.chickenkiller.wearethe.todoapp.R
import com.chickenkiller.wearethe.todoapp.api.model.Todo
import java.util.*

/**
 * Created by spadeworker on 2017. 9. 17..
 */

class TodoContentAdapter : RecyclerView.Adapter<TodoItemViewHolder>() {

    private val items = ArrayList<Todo>()

    override fun onBindViewHolder(holder: TodoItemViewHolder?, position: Int) {
        holder?.let {
            it.bindView(items[position])
        } ?: Log.d("@YJ", "holder is null!!!!")
    }

    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): TodoItemViewHolder {
        parent?.let {
            val itemView = LayoutInflater.from(parent.context).inflate(R.layout.list_item_todo, null)
            return TodoItemViewHolder(itemView)
        } ?: throw IllegalStateException("holder creation failure!!!!")
    }

    override fun getItemCount(): Int = items.size

    fun updateList(items: List<Todo>) {
        this.items.clear()
        this.items.addAll(items)
        this.notifyDataSetChanged()
    }

    fun addItem(todo: Todo) {
        this.items.add(0, todo)
        this.notifyItemInserted(0)
    }

    fun removeItem(itemId: String) {
        val removeList = this.items.filter { it._id.equals(itemId) }
        this.items.removeAll(removeList)
        this.notifyDataSetChanged()
    }
}