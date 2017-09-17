package com.chickenkiller.wearethe.todoapp.api

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import com.google.gson.GsonBuilder


/**
 * Created by spadeworker on 2017. 9. 10..
 */

class ApiManager {

    var baseUrl: String = "https://wearethe.chickenkiller.com/todo/api/"
    var retrofit: Retrofit
    var service: ApiInterface
    var apiDateFormat = "yyyy-MM-dd'T'HH:mm:ss.SSS'Z'"

    init {
        val gson = GsonBuilder()
                .setDateFormat(apiDateFormat)
                .create()
        retrofit = Retrofit.Builder().baseUrl(baseUrl)
                .addConverterFactory(GsonConverterFactory.create(gson)).build()
        service = retrofit.create(ApiInterface::class.java)
    }


    companion object {

        private var INSTANCE: ApiManager? = null

        fun getInstance() : ApiManager {
            if (INSTANCE == null) {
                INSTANCE = ApiManager()
            }

            return INSTANCE!!
        }
    }

}