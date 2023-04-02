package com.example.gatepass

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase

class Data : AppCompatActivity() {
    private lateinit var database : DatabaseReference
    private lateinit var authId: String
    private lateinit var name:TextView
    private lateinit var number:TextView
    private lateinit var course:TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_data)
        name=findViewById(R.id.name)
        number=findViewById(R.id.number)
        course=findViewById(R.id.course)

        authId=intent.getStringExtra("email").toString()
        readData(authId)
    }

    private fun readData(authId: String) {

        database = FirebaseDatabase.getInstance().getReference("Users")
        database.child(authId).get().addOnSuccessListener {
                val firstname = it.child("name1").value
                val lastName = it.child("registration1").value
                val age = it.child("course1").value
                Toast.makeText(this,"Successfuly Read",Toast.LENGTH_SHORT).show()
                name.text = firstname.toString()
                number.text = lastName.toString()
                course.text = age.toString()


        }.addOnFailureListener{

            Toast.makeText(this,"Failed",Toast.LENGTH_SHORT).show()


        }



    }
}
