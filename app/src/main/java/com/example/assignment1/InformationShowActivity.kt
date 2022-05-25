package com.example.assignment1

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.TextView
import com.example.assignment1.databinding.ActivityInformationShowBinding

class InformationShowActivity : AppCompatActivity() {

    private lateinit var binding: ActivityInformationShowBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityInformationShowBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val button: Button = binding.buttonExit

        button.setOnClickListener {
            finish()
        }

        val msg = intent.getStringExtra("msg")

        val textView: TextView = binding.textInfo
        textView.text = msg
    }


}