package com.example.mvp_example.ui.register

class RegisterPresenter(private val registerView: RegisterContracts.View)
    : RegisterContracts.Presenter {

    override fun handleRegister(username: String, password: String) {
        if (username.isEmpty() || password.isEmpty()) {
            registerView.onRegisterFailure(
                "Register Failure: Username or Password is empty!"
            )
        } else {
            registerView.onRegisterSuccess(username, password)
        }
    }
}
