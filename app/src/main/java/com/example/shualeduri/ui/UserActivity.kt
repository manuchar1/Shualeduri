package com.example.shualeduri.ui

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.shualeduri.databinding.ActivityUserBinding


class UserActivity : AppCompatActivity() {

    private lateinit var binding: ActivityUserBinding

    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityUserBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.tvUsername.text = "Hello, ${getValue()}"

        binding.ibBack.setOnClickListener {
            onBackPressed()
        }
    }


    private fun getValue(): String? {

        val prefs = getSharedPreferences("sp", MODE_PRIVATE)
        return prefs.getString("myKey", "")

    }
}