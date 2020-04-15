package com.example.mvp_example.ui.register

interface RegisterContracts {
    interface View {
        fun onRegisterSuccess(username: String, password: String)

        fun onRegisterFailure(errorMessage: String)
    }

    interface Presenter {
        fun handleRegister(username: String, password: String)
    }
}
