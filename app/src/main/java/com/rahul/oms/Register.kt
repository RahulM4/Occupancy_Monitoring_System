package com.rahul.oms

import android.app.ProgressDialog
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Patterns
import android.widget.Toast
import com.google.android.gms.tasks.Task
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase
import com.rahul.oms.databinding.ActivityRegisterBinding
import kotlinx.android.synthetic.main.activity_register.*

class Register : AppCompatActivity() {

    //fire base auth object
    private lateinit var auth: FirebaseAuth
    //view binding object
    private lateinit var binding : ActivityRegisterBinding
    //progress dialog
    private lateinit var progressDialog : ProgressDialog

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityRegisterBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // initialize fire auth
        auth = FirebaseAuth.getInstance()

        // initialize progress dialog
        progressDialog = ProgressDialog(this)
        progressDialog.setTitle("Please wait ....")
        progressDialog.setCanceledOnTouchOutside(false)

        // handle  start registration

        /*
        1) take input credentials
        2) validate datas
        3) create an account - firebase auth
        4) save user info - firebase realtime database
         */
        binding.btnRegister.setOnClickListener{
            validateData()
        }





        already_have_an_account_register.setOnClickListener()
        {
            startActivity(Intent(this@Register, Login::class.java))
            finish()
        }
    }

    private var name = ""
    private  var enrollment = ""
    private var email = ""
    private  var mobile = ""
    private var password = ""




    private fun validateData() {

        name=binding.nameRegister.text.toString().trim()
        enrollment=binding.nameRegister.text.toString().trim()
        email=binding.nameRegister.text.toString().trim()
        mobile=binding.nameRegister.text.toString().trim()
        password=binding.nameRegister.text.toString().trim()
        val confirmPassword=binding.nameRegister.text.toString().trim()
        //val emailPattern = "/[a-z0-9]+@(iiita.ac.in)/gm"

        if(name.isEmpty())
        {
            Toast.makeText(this,"Enter your name",Toast.LENGTH_SHORT).show()
        }
        else if(enrollment.isEmpty())
        {
            Toast.makeText(this,"Enter enrollment number",Toast.LENGTH_SHORT).show()
        }
        else if(!Patterns.EMAIL_ADDRESS.matcher(email).matches())
        {
            Toast.makeText(this,"Enter your valid email",Toast.LENGTH_SHORT).show()
        }
        else if(mobile.isEmpty())
        {
            Toast.makeText(this,"Enter valid mobile number",Toast.LENGTH_SHORT).show()
        }
        else if(password.isEmpty())
        {
            Toast.makeText(this,"Enter password",Toast.LENGTH_SHORT).show()
        }
        else if(confirmPassword.isEmpty())
        {
            Toast.makeText(this,"Confirm password",Toast.LENGTH_SHORT).show()
        }
        else if(password!=confirmPassword)
        {
            Toast.makeText(this,"Password doesn't match",Toast.LENGTH_SHORT).show()
        }
        else
        {
            createUserAccount()
        }


    }
    private fun createUserAccount()
    {
        //show progress
        progressDialog.setMessage("Creating An Account....")
        progressDialog.show()
        //crate an account
        auth.createUserWithEmailAndPassword(email,password)
            .addOnCompleteListener{
                updateUserInfo()

            }
            .addOnFailureListener{ e->
                progressDialog.dismiss()
                Toast.makeText(this,"Failed to create  ${e.message}",Toast.LENGTH_SHORT).show()
            }

    }
    private fun updateUserInfo()
    {
        progressDialog.setMessage("Loading info....")
        val timestamp = System.currentTimeMillis()
        val uid = auth.uid

        val hashMap : HashMap<String ,Any?> = HashMap()
        hashMap["uid"] = uid
        hashMap["email"]= email
        hashMap["name"] =name
        hashMap["enrollment"]= enrollment
        hashMap["mobile"] =mobile
        hashMap["profileImage"]= ""
        hashMap["userType"] ="user"
        hashMap["timestamp"] = timestamp

        val ref = FirebaseDatabase.getInstance().getReference("Users")
        ref.child(uid!!)
            .setValue(hashMap)
            .addOnCompleteListener{
                progressDialog.dismiss()
                Toast.makeText(this,"Account created",Toast.LENGTH_SHORT).show()
                startActivity(Intent(this,DatabaseManagament::class.java))
                finish()
            }
            .addOnFailureListener {e->
                progressDialog.dismiss()
                Toast.makeText(this,"Failed to save info  ${e.message}",Toast.LENGTH_SHORT).show()

            }


    }


}

