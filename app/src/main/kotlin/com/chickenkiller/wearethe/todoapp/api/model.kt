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

