package com.rahul.oms

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.*
import com.rahul.oms.databinding.ActivityUserDashboardBinding


class UserDashboard : AppCompatActivity() {

    private lateinit var binding: ActivityUserDashboardBinding
    private lateinit var auth: FirebaseAuth
    var databaseReference: DatabaseReference? = null
    var database: FirebaseDatabase? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityUserDashboardBinding.inflate(layoutInflater)
        setContentView(binding.root)

        auth = FirebaseAuth.getInstance()
        checkUser()

        binding.logoutBtnDashboard.setOnClickListener{
            auth.signOut()
            startActivity(Intent(this,Home::class.java))
            finish()
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
            //binding.userDashboard.text= name_register.toString()



        }
    }



}