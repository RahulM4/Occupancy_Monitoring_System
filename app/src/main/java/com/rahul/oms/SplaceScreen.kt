package com.rahul.oms

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import com.google.firebase.auth.FirebaseAuth


class SplaceScreen : AppCompatActivity() {
    private lateinit var auth: FirebaseAuth
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splace_screen)
        auth = FirebaseAuth.getInstance()

        Handler().postDelayed(
            {

                startActivity(Intent(this@SplaceScreen, DisplayHome::class.java))
                finish()
            }, 2000)
    }


}