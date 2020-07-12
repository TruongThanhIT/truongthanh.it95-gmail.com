package com.thanht.foodyentrytask

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.annotation.StringRes
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import kotlinx.android.synthetic.main.fragment_login.*
import kotlinx.android.synthetic.main.fragment_login.view.*

class LoginFragment : Fragment() {

    private lateinit var loginViewModel: LoginViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_login, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initUI()
        initEvents()
    }

    private fun initUI() {
        loginViewModel = ViewModelProvider(requireActivity(), LoginViewModelFactory()).get(LoginViewModel::class.java)

        loginViewModel.loginResult.observe(activity as LoginActivity, Observer {
            val loginResult = it ?: return@Observer
            if (loginResult.error != null) {
                showLoginFailed(loginResult.error)
            }
            if (loginResult.success != null) {
                navigateToHome()
            }
        })
    }

    private fun navigateToHome() {
        startActivity(Intent(activity, HomeActivity::class.java))
        activity?.finish()
    }

    private fun showLoginFailed(@StringRes error: Int) {
        Toast.makeText(context, error, Toast.LENGTH_SHORT).show()
    }

    private fun initEvents() {
        requireView().btn_login.setOnClickListener {
            loginViewModel.login(
                userName = et_name.text.toString(),
                password = et_password.text.toString()
            )
        }
    }
}