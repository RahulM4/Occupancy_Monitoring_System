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
       val intent =getIntent()
        val limit =intent.getIntExtra("limit",400)
        max_capacity.text="Max. capacity: "+limit
        available_seats.text="Available seats: "+ limit



    }
}