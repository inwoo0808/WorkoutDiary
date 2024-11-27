package com.example.workoutdiary

import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity

class StatusActivity  : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_status)

        val TimeTextView = findViewById<TextView>(R.id.timeTv)
        val timerButton = findViewById<Button>(R.id.timerButton)
        val addButton = findViewById<Button>(R.id.addButton)

    }
}