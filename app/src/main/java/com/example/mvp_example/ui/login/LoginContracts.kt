package com.example.mvp_example.ui.login

import com.example.mvp_example.data.User

interface LoginContracts {
    interface View {
        fun onLoginSuccess(user: User)

        fun onLoginFailure(errorMessage: String)
    }

    interface Presenter {
        fun handleLogin(username: String, password: String)
    }
}
