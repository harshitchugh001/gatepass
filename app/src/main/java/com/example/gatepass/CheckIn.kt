package com.example.gatepass

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase

class CheckIn : AppCompatActivity() {
    private lateinit var database: DatabaseReference
    private lateinit var auth: FirebaseAuth
    private lateinit var number: EditText
    private lateinit var submit: Button
    private lateinit var details:Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_check_in)

        number = findViewById(R.id.number)
        submit = findViewById(R.id.submit)
        details=findViewById(R.id.details)
        auth = FirebaseAuth.getInstance()

        submit.setOnClickListener(){
            var registration =number.text.toString()
            database = FirebaseDatabase.getInstance().getReference("Inout")
            database.push().setValue(registration).addOnSuccessListener {
                Toast.makeText(this, "check In done", Toast.LENGTH_SHORT).show()
            }.addOnFailureListener {

                Toast.makeText(this, "Failed to checkIn", Toast.LENGTH_SHORT).show()

            }
        }
        details.setOnClickListener(){
            val intent=Intent(this,Show_details::class.java)
            startActivity(intent)
        }




    }
}