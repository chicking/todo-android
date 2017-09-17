package com.chickenkiller.wearethe.todoapp.api

import com.chickenkiller.wearethe.todoapp.api.model.LoginResponse
import com.chickenkiller.wearethe.todoapp.api.model.Todo
import com.chickenkiller.wearethe.todoapp.api.model.TodoList
import com.chickenkiller.wearethe.todoapp.api.model.User
import retrofit2.Call
import retrofit2.http.*

/**
 * Created by spadeworker on 2017. 9. 10..
 */

interface ApiInterface {

    @FormUrlEncoded
    @POST("auth/login")
    fun login(@Field("name") name: String, @Field("password") password: String) : Call<LoginResponse>

    @FormUrlEncoded
    @POST("auth/regist")
    fun registerAccount(@Field("id") id: String,
                        @Field("password") password: String) : Call<LoginResponse>

    @GET("/me")
    fun myInfo(@Header("Authorization") token: String) : Call<User>

    @GET("/todo")
    fun getTodoList(@Header("Authorization") token: String) : Call<TodoList>

    @FormUrlEncoded
    @POST("/todo")
    fun createTodo(@Header("Authorization") token: String,
                   @Field("content") content: String) : Call<Todo>

    @FormUrlEncoded
    @PUT("/todo/{id}")
    fun updateTodo(@Header("Authorization") token: String,
                   @Path("id") id: String,
                   @Field("content") content: String,
                   @Field("done") done: Boolean) : Call<Todo>

    @DELETE("/todo/{id}")
    fun deleteTodo(@Header("Authorization") token: String,
                   @Path("id") id: String) : Call<Todo>
}