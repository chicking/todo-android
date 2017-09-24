package com.chickenkiller.wearethe.todoapp.api

import android.os.Debug
import com.chickenkiller.wearethe.todoapp.BuildConfig
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import com.google.gson.GsonBuilder
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor


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

        val retrofitBuilder = Retrofit.Builder()
                .baseUrl(baseUrl)
                .addConverterFactory(GsonConverterFactory.create(gson))

        if (BuildConfig.DEBUG) {
            val logging = HttpLoggingInterceptor()
            logging.level = HttpLoggingInterceptor.Level.BODY
            val client = OkHttpClient.Builder()
                    .addInterceptor(logging)
                    .build()
            retrofitBuilder.client(client)
        }

        retrofit = retrofitBuilder.build()

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