package com.rahul.oms

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_home.*
import java.util.*

class Home : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        sign_in.setOnClickListener()
        {
            val i= Intent(this@Home,Login::class.java)
            startActivity(i)

        }
        sign_up.setOnClickListener()
        {
            val i= Intent(this@Home,Register::class.java)
            startActivity(i)

        }

        admin.setOnClickListener()
        {
            val i= Intent(this@Home,AdminLogin::class.java)
            startActivity(i)

        }
        help.setOnClickListener()
        {
            val i =Intent(this@Home,Help::class.java)
            startActivity(i)
        }

        val intent = getIntent()
        val limit = intent.getIntExtra("limit",500)
        max_capacity.text="Max. Capacity: " + limit








    }
}