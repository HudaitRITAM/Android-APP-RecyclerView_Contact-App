package com.example.recyclerview

import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class contactActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_contact)

        val username = findViewById<TextView>(R.id.userNames)
        val userContactnumber  = findViewById<TextView>(R.id.contactNumbers)
        val userProfile = findViewById<ImageView>(R.id.userProfiles)

        val name = intent.getStringExtra("name")
        val userContact = intent.getStringExtra("contact")
        val Profile = intent.getIntExtra("profile",R.drawable.image1)

        username.text=name
        userContactnumber.text = userContact
        userProfile.setImageResource(Profile)


        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
}