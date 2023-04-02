package com.example.gatepass

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.cardview.widget.CardView

class Selection : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_selection)

        var student=findViewById<CardView>(R.id.cardView)
        var gaurds=findViewById<CardView>(R.id.cardView1)
        student.setOnClickListener(){
            val intent= Intent(this,Student_login::class.java)
            startActivity(intent)
        }
        gaurds.setOnClickListener(){
            val i=Intent(this,Login::class.java)
            startActivity(i)
        }

    }
}