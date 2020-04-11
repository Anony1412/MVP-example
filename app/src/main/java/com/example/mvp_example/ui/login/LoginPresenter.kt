package com.example.mvp_example.ui.login

import android.util.Log
import com.example.mvp_example.data.User

class LoginPresenter(private val loginView: LoginContracts.View) : LoginContracts.Presenter {

    override fun handleLogin(username: String, password: String) {
        if (username.isEmpty() || password.isEmpty()) {
            loginView.onLoginFailure("Login Failure: Username or Password is empty!")
        } else {
            var isLoginSuccess = false
            for (user in LoginActivity.userList) {
                Log.d("handleLogin", "1")
                if (user.username.equals(username) && user.password.equals(password)) {
                    loginView.onLoginSuccess(User(username, password))
                    isLoginSuccess = true
                    break
                }
            }
            if (!isLoginSuccess) {
                loginView.onLoginFailure("Login Failure: Wrong Username or Password!")
            }
        }
    }
}
