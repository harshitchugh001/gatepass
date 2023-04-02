package com.example.gatepass

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.cardview.widget.CardView

class Edit_details : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_edit_details)

        var register=findViewById<CardView>(R.id.cardView)
        var details=findViewById<CardView>(R.id.cardView1)
        var checkIn=findViewById<CardView>(R.id.cardView2)
        var checkout=findViewById<CardView>(R.id.cardView3)
        register.setOnClickListener(){
            val intent= Intent(this,MainActivity::class.java)
            startActivity(intent)
        }
        details.setOnClickListener(){
            val i= Intent(this,Home::class.java)
            startActivity(i)
        }
        checkIn.setOnClickListener(){
            val intent1=Intent(this,Demo::class.java)
            startActivity(intent1)
        }
        checkout.setOnClickListener(){
            val intent2=Intent(this,Checkout::class.java)
            startActivity(intent2)
        }
    }
}