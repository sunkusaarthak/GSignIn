package com.example.gsignin

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import coil.load
import com.google.android.gms.auth.api.signin.GoogleSignIn
import com.google.android.gms.auth.api.signin.GoogleSignInOptions

class Center : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_center)
        supportActionBar?.hide()
        val familyName = intent.getStringExtra("family name")
        val displayName = intent.getStringExtra("display name")
        val name = intent.getStringExtra("name")
        val email = intent.getStringExtra("email")
        val id = intent.getStringExtra("id")
        val photoURL = intent.getStringExtra("photo url")
        var imageProfile: ImageView = findViewById<ImageView>(R.id.Profile)
        var nameText: TextView = findViewById<TextView>(R.id.Name)
        var displayNameText = findViewById<TextView>(R.id.GivenName)
        var familyNameText = findViewById<TextView>(R.id.FamilyName)
        var logOut = findViewById<Button>(R.id.LogOut)
        val gso = GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
            .requestEmail()
            .build()
        var mGoogleSignInClient = GoogleSignIn.getClient(this, gso)
        imageProfile.load(photoURL)
        nameText.text = displayName
        displayNameText.text = displayName
        familyNameText.text = email

        logOut.setOnClickListener(View.OnClickListener {
            mGoogleSignInClient.signOut().addOnCompleteListener {
                val intent = Intent(this, MainActivity::class.java)
                startActivity(intent)
                finish()
            }
        })
    }
}