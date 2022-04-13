package com.rahul.oms

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.google.firebase.auth.FirebaseAuth
import com.rahul.oms.databinding.ActivityAdminDashboardBinding
import kotlinx.android.synthetic.main.activity_admin_dashboard.*


class AdminDashboard : AppCompatActivity() {
    private lateinit var binding: ActivityAdminDashboardBinding
    private lateinit var auth : FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityAdminDashboardBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // initialize objects
        auth= FirebaseAuth.getInstance()
        checkingUser()

        logout_admin.setOnClickListener()
        {
            startActivity(Intent(this@AdminDashboard,AdminLogin::class.java))
            auth.signOut()
            checkingUser()
        }

        Update_Availability.setOnClickListener()
        {
            startActivity(Intent(this@AdminDashboard,SetOccupancyLimit::class.java))
            finish()
        }

    }

    private fun checkingUser() {
        val firebaseUser= auth.currentUser
        if(firebaseUser == null)
        {
            startActivity(Intent(this@AdminDashboard,Home::class.java))
            finish()

        }
        else
        {
            val email = firebaseUser.email
            binding.nameAdmin.text=email


        }
    }
}