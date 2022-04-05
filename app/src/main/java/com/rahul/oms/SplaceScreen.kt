package com.rahul.oms

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler


class SplaceScreen : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splace_screen)

        Handler().postDelayed(
            {
                val i = Intent(this@SplaceScreen, DisplayHome::class.java)
                startActivity(i)
                finish()
            }, 2000)
    }
}