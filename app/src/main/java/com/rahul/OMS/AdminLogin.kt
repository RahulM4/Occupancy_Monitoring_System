package com.rahul.OMS

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.text.TextUtils
import android.widget.EditText
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_admin_login.*
import kotlinx.android.synthetic.main.activity_home.*

class AdminLogin : AppCompatActivity() {
    //private lateinit var binding: AdminLogin
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_admin_login)


        admin_login_btn.setOnClickListener()
        {
            performLogin()


        }
        admin_clear_btn.setOnClickListener()
        {
            admin_email.text.clear()

        }




    }

    private fun performLogin() {

        val email = admin_email.text.toString()
        val password = admin_password.text.toString()

        if(email.isNotEmpty() && password.isNotEmpty())
        {
            /*user.createUserWithEmailAndPassword(email,password).addOnCompleteListener(AdminLogin())
            { task->
                if(task.isSuccessful)
                {
                    Toast.makeText(this,"Successfully Logged In",Toast.LENGTH_SHORT).show()
                    startActivity(Intent(this@AdminLogin,Admin::class.java))
                    finish()
                }
                else
                {
                    Toast.makeText(this,task.exception!!.message,Toast.LENGTH_SHORT).show()
                }
            }*/
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
            Toast.makeText(this,"Please enter some credentials to LogIn",Toast.LENGTH_SHORT).show()
        }
    }


}