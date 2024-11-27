package com.example.workoutdiary

import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity

class IsRoutineActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_isroutine)

        val timerTextView = findViewById<TextView>(R.id.timerTv)
        val startButton = findViewById<Button>(R.id.startButton)
        val startTextView = findViewById<TextView>(R.id.startTv)

    }
}