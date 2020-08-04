package com.thanht.foodyentrytask.home

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity


class HomeActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        supportFragmentManager.beginTransaction().add(android.R.id.content,
            HomeFragment()
        ).commit()
    }
}