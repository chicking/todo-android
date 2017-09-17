package com.chickenkiller.wearethe.todoapp.api.model

import java.util.*

/**
 * Created by spadeworker on 2017. 9. 10..
 */

data class User (var _id: Long, var updated_at: Date, var name: String, var created_at: Date) {
    override fun toString(): String {
        return "User(_id=$_id, updatedAt=$updated_at, name='$name', createdAt=$created_at)"
    }
}

data class Todo (var _id: String,
                 var content: String,
                 var done: Boolean,
                 var user_id: Long,
                 var updated_at: Date,
                 var created_at: Date) {
    override fun toString(): String {
        return "Todo(_id='$_id', content='$content', done=$done, user_id=$user_id, " +
                "updated_at=$updated_at, created_at=$created_at)"
    }
}

data class TodoList (var todos: List<Todo>) {
    override fun toString(): String {

        var content = ""
        for (todo in this.todos) {
            content += "$todo\n"
        }

        return "TodoList(todos=$content)"
    }
}

data class LoginResponse(var token : String, var user : User) {
    override fun toString(): String {
        return "LoginResponse(token='$token', user=$user)"
    }
}

data class FailResponse(var message : String) {
    override fun toString(): String {
        return "FailResponse(message='$message')"
    }
}

