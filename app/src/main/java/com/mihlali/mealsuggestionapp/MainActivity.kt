package com.mihlali.mealsuggestionapp

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        val btnProcess = findViewById<Button>(R.id.btnProcess)
        val edtInput = findViewById<EditText>(R.id.edtInput)
        val textOutput = findViewById<TextView>(R.id.textOutput)
        val btnReset = findViewById<Button>(R.id.btnReset)

        btnReset.setOnClickListener {
            edtInput.text.clear()
            textOutput.text = " "

            btnProcess.setOnClickListener {
                val userInput = edtInput.text.toString().trim()
                textOutput.text = when (userInput.lowercase()) {
                    "morning" -> "Breakfast : eggs, bacon, Pancakes"
                    "mid-morning" -> "Snack: Fruit, Granola bar, muffin"
                    "afternoon" -> "Lunch: Sandwich, salad, fat cook"
                    "mid-afternoon" -> "light snack: slice of cake, fried chips, donut"
                    "dinner" -> "Supper: Pasta, Steak, Ribs, Rice and Chicken"
                    else -> "Please enter a valid time of day"
                }
            }
        }
    }
}