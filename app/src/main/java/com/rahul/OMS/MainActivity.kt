package com.rahul.OMS

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        Handler().postDelayed(
            {
                val i = Intent(this@MainActivity, Home::class.java)
                startActivity(i)
                finish()
            }, 2000)
    }
}