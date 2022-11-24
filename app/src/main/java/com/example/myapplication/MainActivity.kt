package com.example.myapplication

import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView

class MainActivity : AppCompatActivity() {

    private lateinit var pref: SharedPreferences

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        supportActionBar?.hide()
        val btn: Button = findViewById(R.id.button)
        val name: EditText = findViewById(R.id.editTextTextPersonName)
        pref = getSharedPreferences("MAIN", MODE_PRIVATE)
        val changesText: TextView = findViewById(R.id.textView)
        changesText.text = getInf("aha")

        btn.setOnClickListener {
            setInf("aha", name.text.toString())
            changesText.text = getInf("aha")
        }
    }

    private fun getInf(key: String): String? {
        return pref.getString("aha", "")
    }

    private fun setInf(key: String, value: String){
        val editor = pref.edit()
        editor.putString(key, value)
        editor.commit()
    }
}