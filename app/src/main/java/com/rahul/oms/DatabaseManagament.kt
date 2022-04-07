package com.rahul.oms

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.*
import com.rahul.oms.databinding.ActivityDatabaseManagamentBinding
import kotlinx.android.synthetic.main.activity_database_managament.*
import kotlinx.android.synthetic.main.activity_login.*
import kotlinx.android.synthetic.main.activity_register.*

class DatabaseManagament : AppCompatActivity() {

    private lateinit var binding: ActivityDatabaseManagamentBinding
    private lateinit var auth: FirebaseAuth
    var databaseReference: DatabaseReference? = null
    var database: FirebaseDatabase? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityDatabaseManagamentBinding.inflate(layoutInflater)
        setContentView(binding.root)

        auth = FirebaseAuth.getInstance()
        checkUser()
        binding.logoutBtnDashboard.setOnClickListener{
            auth.signOut()
            startActivity(Intent(this,DisplayHome::class.java))
        }

    }

    private fun checkUser() {

        val firebaseUser= auth.currentUser
        if(firebaseUser == null)
        {
            binding.subTitleDashboard.text="Not yet logged in"
            finish()

        }
        else
        {
            val email = firebaseUser.email
            binding.subTitleDashboard.text=email


        }
    }



}