package com.aditya.catatanpenjualan.activity.login

import com.aditya.catatanpenjualan.activity.login.data.ResultLogin
import com.aditya.catatanpenjualan.model.User
import com.aditya.catatanpenjualan.network.NetworkConfig
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class LoginPresenter(val loginView: LoginView) {
    fun login(user: User) {
        NetworkConfig.service()
            .loginUser(user.username, user.password)
            .enqueue(object : Callback<ResultLogin> {
                override fun onFailure(call: Call<ResultLogin>, t: Throwable) {
                    loginView.onErrorLogin(t.localizedMessage)
                }

                override fun onResponse(call: Call<ResultLogin>, response: Response<ResultLogin>) {
                    val body = response.body()

                    if (body?.status == 200) {
                        loginView.onSuccessLogin(body.user)
                    } else {
                        loginView.onErrorLogin(body?.message)
                    }
                }

            })
    }
}