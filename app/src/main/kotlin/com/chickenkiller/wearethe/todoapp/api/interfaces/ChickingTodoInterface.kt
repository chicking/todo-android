package com.chickenkiller.wearethe.todoapp.api.interfaces

import com.chickenkiller.wearethe.todoapp.api.model.LoginResponse
import retrofit2.Call
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.POST

/**
 * Created by spadeworker on 2017. 9. 10..
 */

interface ChickingTodoInterface {

    @FormUrlEncoded
    @POST("auth/login")
    fun login(@Field("name") name: String, @Field("password") password: String) : Call<LoginResponse>

    @FormUrlEncoded
    @POST("auth/regist")
    fun registerAccount(@Field("id") id: String,
                        @Field("password") password: String) : Call<LoginResponse>


}