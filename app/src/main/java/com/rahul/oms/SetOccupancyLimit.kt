package com.rahul.oms

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_set_occupancy_limit.*

class SetOccupancyLimit : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_set_occupancy_limit)


        btn_cancel.setOnClickListener()
        {
            startActivity(Intent(this@SetOccupancyLimit,AdminDashboard::class.java))
        }

        btn_ok.setOnClickListener()
        {
            val limit=txt_input.text.toString().toInt()
            val i = Intent(this@SetOccupancyLimit,Home::class.java)
            i.putExtra("limit",limit)
            startActivity(i)
        }


    }
}