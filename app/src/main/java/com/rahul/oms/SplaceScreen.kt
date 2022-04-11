package com.rahul.oms

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener


class SplaceScreen : AppCompatActivity() {
    private lateinit var auth: FirebaseAuth
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splace_screen)
        auth = FirebaseAuth.getInstance()

        Handler().postDelayed(
            {
                checkUser()

            }, 2000)
    }

    private fun checkUser() {
        val firebaseUser = auth.currentUser
        if(firebaseUser==null)
        {

            startActivity(Intent(this@SplaceScreen, DisplayHome::class.java))
            finish()
        }
        else
        {
            val ref= FirebaseDatabase.getInstance().getReference("Users")
            ref.child(firebaseUser.uid)
                .addListenerForSingleValueEvent(object : ValueEventListener {

                    override fun onDataChange(snapshot: DataSnapshot) {
                        val userType = snapshot.child("userType").value
                        if(userType =="user")
                        {
                            startActivity(Intent(this@SplaceScreen,DatabaseManagament::class.java))
                            finish()
                        }
                        else if(userType == "admin")
                        {
                            startActivity(Intent(this@SplaceScreen,DatabaseManagament::class.java))
                            finish()
                        }

                    }

                    override fun onCancelled(error: DatabaseError) {
                        TODO("Not yet implemented")
                    }
                })
        }
    }


}