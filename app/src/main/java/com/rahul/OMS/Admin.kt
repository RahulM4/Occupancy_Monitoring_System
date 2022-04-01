package com.rahul.OMS

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_admin.*
import kotlinx.android.synthetic.main.activity_home.*

class Admin : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_admin)

        admin_logout.setOnClickListener()
        {
            startActivity(Intent(this@Admin,Home::class.java))
        }


        Update_Availability.setOnClickListener()
        {
            max_capacity
        }

    }
}