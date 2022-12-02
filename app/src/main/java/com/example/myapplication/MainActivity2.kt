package com.example.myapplication

import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView

class MainActivity2 : AppCompatActivity() {

    lateinit var pref: SharedPreferences

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)
        supportActionBar?.hide()
        var results: TextView = findViewById(R.id.textView3)
        pref = getSharedPreferences("MAIN", MODE_PRIVATE)
        val bttn: Button = findViewById(R.id.button2)
        results.text = getInfo("aha")
        bttn.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
            finish()
        }
    }

    private fun getInfo(key: String): String?{
        return pref.getString("aha", "")
    }
}