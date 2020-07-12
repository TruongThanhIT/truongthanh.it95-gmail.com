package com.thanht.foodyentrytask

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import androidx.appcompat.app.AppCompatActivity

private const val DELAY_TIME = 2000L

class SplashActivity : AppCompatActivity() {
    private var handler: Handler? = null

    private val runnable = Runnable {
        handleNavigate()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        handler = Handler()
        handler!!.postDelayed(runnable, DELAY_TIME)
    }

    override fun onDestroy() {
        handler?.removeCallbacks(runnable)
        super.onDestroy()
    }

    private fun handleNavigate() {
//        val user = User("", "123")
//        val intent: Intent
//        intent = if (user.userName.isNotEmpty()) {
//            Intent(this, HomeActivity::class.java)
//        } else {
//            Intent(this, LoginActivity::class.java)
//        }
//        startActivity(intent)
        startActivity(Intent(this, LoginActivity::class.java))
        finish()
    }
}