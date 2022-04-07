package com.rahul.oms

import android.app.ProgressDialog
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.ContactsContract
import android.util.Patterns
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener
import com.rahul.oms.databinding.ActivityLoginBinding
import kotlinx.android.synthetic.main.activity_login.*

class Login : AppCompatActivity() {
    private lateinit var binding: ActivityLoginBinding
    private lateinit var auth: FirebaseAuth
    private lateinit var progressDailog: ProgressDialog


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)


        auth = FirebaseAuth.getInstance()
        progressDailog= ProgressDialog(this)
        progressDailog.setTitle("Please wait while logging....")
        progressDailog.setCanceledOnTouchOutside(false)

        binding.newUserGuestLogin.setOnClickListener{
            startActivity(Intent(this,DatabaseManagament::class.java))
        }

        binding.loginBtnLogin.setOnClickListener{

            validateData()

        }



        forget_password_login.setOnClickListener()
        {
            startActivity(Intent(this@Login,MobileotpVerification::class.java))
        }


    }

    private var email = ""
    private var password = ""

    private fun validateData() {
        email =binding.emailLogin.text.toString().trim()
        password =binding.passwordLogin.text.toString().trim()
        //validate email

        if(!Patterns.EMAIL_ADDRESS.matcher(email).matches())
        {
            Toast.makeText(this,"Invalid email id",Toast.LENGTH_SHORT).show()

        }
        else if(password.isEmpty())
        {
            Toast.makeText(this,"Enter password",Toast.LENGTH_SHORT).show()
        }
        else
        {
            loginUser()
        }

    }

    private fun loginUser()
    {
        progressDailog.setMessage("Logging In....")
        progressDailog.show()

        auth.signInWithEmailAndPassword(email,password)
            .addOnCompleteListener{
                checkingUser()

            }
            .addOnFailureListener {  e->
                Toast.makeText(this,"Login Failed due to ${e.message}",Toast.LENGTH_SHORT).show()

            }

    }

    private fun checkingUser() {
        progressDailog.setMessage("Finding user....")

        val firebaseUser = auth.currentUser!!
        val ref= FirebaseDatabase.getInstance().getReference("Users")
        ref.child(firebaseUser.uid)
            .addListenerForSingleValueEvent(object : ValueEventListener{

                override fun onDataChange(snapshot: DataSnapshot) {
                    progressDailog.dismiss()
                    val userType = snapshot.child("userType").value
                    if(userType =="user")
                    {
                        startActivity(Intent(this@Login,DatabaseManagament::class.java))
                        finish()
                    }
                    else if(userType == "admin")
                    {
                       startActivity(Intent(this@Login,DatabaseManagament::class.java))
                        finish()
                    }

                }

                override fun onCancelled(error: DatabaseError) {
                    TODO("Not yet implemented")
                }
            })
    }


}