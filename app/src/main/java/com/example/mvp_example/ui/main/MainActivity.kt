package com.example.mvp_example.ui.main

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.example.mvp_example.R
import com.example.mvp_example.ui.login.LoginActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), View.OnClickListener {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        setContent()
        registerListeners()
    }

    private fun setContent() {
        val user = intent.getSerializableExtra(LoginActivity.USER_SESSION)
        textContent.text = user?.toString()
    }

    private fun registerListeners() {
        buttonLogout.setOnClickListener(this)
    }

    override fun onClick(v: View?) {
        when (v?.id) {
            R.id.buttonLogout -> handleLogOut()
        }
    }

    private fun handleLogOut() {
        startActivity(Intent(this, LoginActivity::class.java))
    }
}
