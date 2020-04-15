package com.example.mvp_example.ui.register

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import com.example.mvp_example.R
import com.example.mvp_example.data.User
import com.example.mvp_example.ui.login.LoginActivity
import kotlinx.android.synthetic.main.activity_register.*

class RegisterActivity : AppCompatActivity(), RegisterContracts.View, View.OnClickListener {

    private lateinit var registerPresenter: RegisterPresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)

        registerPresenter = RegisterPresenter(this)
        registerListeners()
    }

    private fun registerListeners() {
        buttonRegister.setOnClickListener(this)
    }

    override fun onRegisterSuccess(username: String, password: String) {
        Toast.makeText(
            this,
            "Register account is successfully!",
            Toast.LENGTH_SHORT
        ).show()
        addMemberToUserList(username, password)
        onLoginScreenStart()
    }

    private fun addMemberToUserList(username: String, password: String) {
        LoginActivity.userList.add(User(username, password))
    }

    private fun onLoginScreenStart() {
        startActivity(Intent(this, LoginActivity::class.java))
    }

    override fun onRegisterFailure(errorMessage: String) {
        Toast.makeText(this, errorMessage, Toast.LENGTH_SHORT).show()
    }

    override fun onClick(v: View?) {
        when (v?.id) {
            R.id.buttonRegister -> handleRegister()
        }
    }

    private fun handleRegister() {
        registerPresenter.handleRegister(textUsername.text.toString(), textPassword.text.toString())
    }
}
