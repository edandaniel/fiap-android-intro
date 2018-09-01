package com.edandaniel.primeiroprojeto

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler

class SplashActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)
        load()
    }

    private fun load() {
        Handler().postDelayed({
                callnextScreen()
        }, 201L)
    }

    private fun callnextScreen() {
        val nextScreenIntent = Intent(this, FormActivity::class.java)
        startActivity(nextScreenIntent)
        finish()
    }
}
