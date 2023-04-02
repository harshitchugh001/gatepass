package com.example.gatepass

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth

class Student_login : AppCompatActivity() {
    private lateinit var auth : FirebaseAuth
    private lateinit var login: Button
    private lateinit var email1: EditText
    private lateinit var pass1: EditText
    private lateinit var number:EditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_student_login)

        auth = FirebaseAuth.getInstance()

        login=findViewById(R.id.Login)
        email1=findViewById(R.id.email)
        pass1=findViewById(R.id.password)
        number=findViewById(R.id.number)


        login.setOnClickListener(){
            var email = email1.text.toString()
            var pass = pass1.text.toString()
            var number1=number.text.toString()
            if (email.isNotEmpty() && pass.isNotEmpty()) {

                auth.signInWithEmailAndPassword(email, pass).addOnCompleteListener {
                    if (it.isSuccessful) {
                        val intent = Intent(this, Data::class.java)
                        intent.putExtra("email", number1)
                        startActivity(intent)
                    } else {
                        Toast.makeText(this, it.exception.toString(), Toast.LENGTH_SHORT).show()

                    }
                }
            } else {
                Toast.makeText(this, "Empty Fields Are not Allowed !!", Toast.LENGTH_SHORT).show()

            }
        }

    }

}
