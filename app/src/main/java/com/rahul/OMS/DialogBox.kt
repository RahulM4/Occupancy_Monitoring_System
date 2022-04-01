package com.rahul.OMS

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_admin_login.*
import kotlinx.android.synthetic.main.activity_dialog_box.*

class DialogBox : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_dialog_box)


        btn_cancel.setOnClickListener()
        {
            startActivity(Intent(this@DialogBox,Admin::class.java))
        }

        btn_ok.setOnClickListener()
        {
            var limit=txt_input.text.toString().toInt()
            val i = Intent(this@DialogBox,Home::class.java)
            i.putExtra("limit",limit)
            startActivity(i)
        }


    }
}