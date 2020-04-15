package com.example.mvp_example.ui.login

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.mvp_example.R
import com.example.mvp_example.data.User
import com.example.mvp_example.ui.main.MainActivity
import com.example.mvp_example.ui.register.RegisterActivity
import kotlinx.android.synthetic.main.activity_login.*

class LoginActivity: AppCompatActivity(), View.OnClickListener,
    LoginContracts.View {

    private lateinit var loginPresenter: LoginPresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        loginPresenter = LoginPresenter(this)
        registerListeners()
    }

    private fun registerListeners() {
        buttonLogin.setOnClickListener(this)
        textRegister.setOnClickListener(this)
    }

    override fun onClick(v: View?) {
        when (v?.id) {
            R.id.buttonLogin -> handleLogin()
            R.id.textRegister -> onRegisterScreenStart()
        }
    }

    private fun onRegisterScreenStart() {
        startActivity(Intent(this, RegisterActivity::class.java))
    }

    private fun handleLogin() {
        loginPresenter.handleLogin(textUsername.text.toString(), textPassword.text.toString())
    }

    override fun onLoginSuccess(user: User) {
        onMainScreenStart(user)
    }

    private fun onMainScreenStart(user: User) {
        val intent = Intent(this, MainActivity::class.java).apply {
            putExtra(USER_SESSION, user)
        }
        startActivity(intent)
    }

    override fun onLoginFailure(errorMessage: String) {
        Toast.makeText(this, errorMessage, Toast.LENGTH_SHORT).show()
    }

    companion object {
        const val USER_SESSION = "user_session"
        val userList: ArrayList<User> = ArrayList()
    }
}
