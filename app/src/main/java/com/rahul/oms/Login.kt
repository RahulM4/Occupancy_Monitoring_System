package com.rahul.oms

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.rahul.oms.R
import kotlinx.android.synthetic.main.activity_login.*

class Login : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        new_user_guest.setOnClickListener()
        {
            val i= Intent(this@Login,Register::class.java)
            startActivity(i)



        }

        forget_password.setOnClickListener()
        {
            val i =Intent(this@Login,MobileotpVerification::class.java)
            startActivity(i)
        }
    }
}