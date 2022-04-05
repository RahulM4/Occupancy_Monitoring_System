package com.rahul.oms

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_display_home.*

class DisplayHome : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_display_home)

        help.setOnClickListener()
        {
            startActivity(Intent(this,Help::class.java))

        }
        admin.setOnClickListener(){
            startActivity(Intent(this,AdminLogin::class.java))
        }
        sign_in.setOnClickListener()
        {
            startActivity(Intent(this,Login::class.java))
        }
        sign_up.setOnClickListener()
        {
            startActivity(Intent(this,Register::class.java))
        }


    }
}