package com.rahul.OMS

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_home.*
import java.text.SimpleDateFormat
import java.util.*

class Home : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {

        lateinit var calendar: Calendar
        lateinit var simpleDateFormat: SimpleDateFormat
        lateinit var date: Date


        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        enter.setOnClickListener()
        {
            val i= Intent(this@Home,Register::class.java)
            startActivity(i);

        }

        admin.setOnClickListener()
        {
            val i= Intent(this@Home,AdminLogin::class.java)
            startActivity(i);

        }
        help.setOnClickListener()
        {
            val i =Intent(this@Home,Help::class.java)
            startActivity(i)
        }




    }
}