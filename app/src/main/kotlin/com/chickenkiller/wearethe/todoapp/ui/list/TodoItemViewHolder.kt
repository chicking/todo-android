package com.chickenkiller.wearethe.todoapp.ui.list

import android.support.v7.widget.RecyclerView
import android.view.View
import android.widget.TextView
import com.chickenkiller.wearethe.todoapp.R
import com.chickenkiller.wearethe.todoapp.api.model.Todo

/**
 * Created by spadeworker on 2017. 9. 17..
 */

class TodoItemViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

    val contentTextView: TextView = itemView.findViewById(R.id.content_textview) as TextView

    fun bindView(todo: Todo) {
        contentTextView.text = todo.content
        //TODO: todo의 done 값에 따라 다르게 나타내도록 처리
    }

}