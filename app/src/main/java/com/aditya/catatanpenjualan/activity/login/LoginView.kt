package com.aditya.catatanpenjualan.activity.login

import com.aditya.catatanpenjualan.model.User

interface LoginView {
    fun onSuccessLogin(user: User?)
    fun onErrorLogin(msg: String?)
}