package com.thanht.foodyentrytask.login

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.annotation.StringRes
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import com.thanht.foodyentrytask.home.HomeActivity
import com.thanht.foodyentrytask.R
import com.thanht.foodyentrytask.ext.userComponent
import kotlinx.android.synthetic.main.activity_login.*
import javax.inject.Inject

class LoginActivity : AppCompatActivity() {

    @Inject
    lateinit var loginViewModel: LoginViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        userComponent().inject(this)
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        initEvents()

        loginViewModel.loginResult.observe(this, Observer {
            val loginResult = it ?: return@Observer
            if (loginResult.error != null) {
                showLoginFailed(loginResult.error)
            }
            if (loginResult.success != null) {
                navigateToHome()
            }
        })
    }

    private fun initEvents() {
        btn_login.setOnClickListener {
            loginViewModel.login(
                userName = et_name.text.toString(),
                password = et_password.text.toString()
            )
        }
    }

    private fun navigateToHome() {
        startActivity(Intent(this, HomeActivity::class.java))
        finish()
    }

    private fun showLoginFailed(error: String) {
        Toast.makeText(this, error, Toast.LENGTH_SHORT).show()
    }
}