package com.chickenkiller.wearethe.todoapp.ui.fragment

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import android.widget.Toast
import com.chickenkiller.wearethe.todoapp.R
import com.chickenkiller.wearethe.todoapp.api.ApiManager
import com.chickenkiller.wearethe.todoapp.api.model.LoginResponse
import com.chickenkiller.wearethe.todoapp.ui.base.BaseFragment
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

/**
 * Created by spadeworker on 2017. 9. 10..
 */

class LoginFragment : BaseFragment() {

    var idEditText: EditText? = null
    var pwEditText: EditText? = null

    override fun onCreateView(inflater: LayoutInflater?,
                              container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        val view = inflater?.inflate(R.layout.fragment_login, null)

        idEditText = view?.findViewById(R.id.id_edittext) as EditText
        pwEditText = view?.findViewById(R.id.pw_edittext) as EditText

        view.findViewById(R.id.signin_btn).setOnClickListener { onClickSignIn() }


        return view
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

    }

    fun onClickSignIn() {
        val apiManager = ApiManager.getInstance()
        var request = apiManager.service.login(idEditText?.text.toString(), pwEditText?.text.toString())
        request.enqueue(object : Callback<LoginResponse> {
            override fun onFailure(call: Call<LoginResponse>?, t: Throwable?) {
                Toast.makeText(this@LoginFragment.activity, "Login fail!!!!", Toast.LENGTH_LONG).show()
                Log.d("@YJ", t.toString())
            }

            override fun onResponse(call: Call<LoginResponse>?, response: Response<LoginResponse>?) {
                response?.let {
                    if (it.isSuccessful) {
                        Toast.makeText(this@LoginFragment.activity, "Login Success!!!!", Toast.LENGTH_LONG).show()
                    } else {
                        Toast.makeText(this@LoginFragment.activity, "Login fail!!!!", Toast.LENGTH_LONG).show()
                    }

                    Log.d("@YJ", response.body().toString())
                }
            }
        })
    }
}