package com.example.shualeduri.ui

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.example.shualeduri.R
import com.example.shualeduri.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity(), View.OnClickListener {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.ibNext.setOnClickListener(this)
        binding.ibUser.setOnClickListener(this)

    }

    @SuppressLint("CommitPrefEdits")
    override fun onClick(view: View?) {
        when (view?.id) {
            R.id.ibUser -> {
                val intent = Intent(this, UserActivity::class.java)
                startActivity(intent)
            }
            R.id.ibNext -> {
                val value = binding.etName.text.toString().trim()
                val sharedPref = getSharedPreferences("sp", MODE_PRIVATE)
                val editor = sharedPref.edit()
                editor.putString("myKey", value)
                editor.apply()
                val intent = Intent(this, UserActivity::class.java)
                startActivity(intent)
            }
        }
    }
}