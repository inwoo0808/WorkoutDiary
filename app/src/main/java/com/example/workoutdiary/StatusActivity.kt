package com.example.workoutdiary

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity

class StatusActivity  : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_status)

        val timerButton = findViewById<Button>(R.id.timerButton)
        val addButton = findViewById<Button>(R.id.addButton)
        val firstButton = findViewById<Button>(R.id.firstButton)

        timerButton.setOnClickListener {
            // Toast 메시지 표시
            Toast.makeText(this, "운동 루틴을 추가하세요", Toast.LENGTH_SHORT).show()
        }
        addButton.setOnClickListener {
            // StatusActivity로 전환
            val intent = Intent(this, RoutineActivity::class.java)
            startActivity(intent)
        }
        firstButton.setOnClickListener {
            // StatusActivity로 전환
            val intent = Intent(this, RoutineActivity::class.java)
            startActivity(intent)
        }
    }
}