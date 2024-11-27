package com.example.workoutdiary

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity

class RoutineActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_routine)

        //변수 초기화
        val titleTextView = findViewById<TextView>(R.id.titleTv)
        val routineNameTextView = findViewById<TextView>(R.id.routineNameTv)
        val routineEditText = findViewById<EditText>(R.id.routineET)
        val targetTextView = findViewById<TextView>(R.id.targetTv)
        val sholderButton = findViewById<Button>(R.id.sholderButton)
        val backButton = findViewById<Button>(R.id.backButton)
        val absButton = findViewById<Button>(R.id.absButton)
        val armButton = findViewById<Button>(R.id.armButton)
        val legButton = findViewById<Button>(R.id.legButton)
        val hipButton = findViewById<Button>(R.id.hipButton)
        val allButton = findViewById<Button>(R.id.allButton)
        val cardioButton = findViewById<Button>(R.id.cardioButton)
        val infoTextView = findViewById<TextView>(R.id.infoTv)
        val searchButton = findViewById<Button>(R.id.searchButton)
        val addButton = findViewById<Button>(R.id.addButton)

    }
}