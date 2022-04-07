package com.rahul.oms

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_admin_login.*


class AdminLogin : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_admin_login)


        login_btn_admin_login.setOnClickListener()
        {
            performLogin()

        }




    }

    private fun performLogin() {

        val email = email_admin_login.text.toString()
        val password = password_admin_login.text.toString()

        if(email.isNotEmpty() && password.isNotEmpty())
        {

            if(email.equals("abcd@gmail.com")&& password.equals("1111abcd"))
            {
                Toast.makeText(this,"Successfully Logged In",Toast.LENGTH_SHORT).show()
                startActivity(Intent(this@AdminLogin,Admin::class.java))
                finish()
            }
            else
            {
                Toast.makeText(this,"Wrong EmailId or Password",Toast.LENGTH_LONG).show()

            }

        }
        else
        {
            Toast.makeText(this,"Please enter all required details to LogIn",Toast.LENGTH_SHORT).show()

        }
    }


}