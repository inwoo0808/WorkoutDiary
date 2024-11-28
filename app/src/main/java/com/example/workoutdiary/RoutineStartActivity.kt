package com.example.workoutdiary;

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity

public class RoutineStartActivity  : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_routinestart)

        val titleTextView = findViewById<TextView>(R.id.titleTv)
        val setTextView = findViewById<TextView>(R.id.setTv)
        val startButton = findViewById<Button>(R.id.startButton)

        startButton.setOnClickListener {
            val intent = Intent(this, RoutineTimerActivity::class.java)
            startActivity(intent)
        }

    }

}

