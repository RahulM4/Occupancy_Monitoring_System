package com.rahul.OMS

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_admin_login.*

class DialogBox : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_dialog_box)
        val text1=findViewById<TextView>(R.id.Numerical)
        val btncancel=findViewById<Button>(R.id.btn_cancel)
        val btnok=findViewById<Button>(R.id.btn_okay)
        val edittext=findViewById<EditText>(R.id.txt_input)
        val text2 = edittext.text.toString()
        btncancel.setOnClickListener()
        {
            edittext.text.clear()
            startActivity(Intent(this@DialogBox,Admin::class.java))
        }
        btnok.setOnClickListener()
        {
            text1.setText(text2)
            Toast.makeText(this,"New Limit is set now!!", Toast.LENGTH_SHORT).show()
            startActivity(Intent(this@DialogBox,Admin::class.java))
        }
    }
}