package com.example.workoutdiary

import android.content.Intent
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import android.widget.Button

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        // 버튼 클릭 이벤트
        val button = findViewById<Button>(R.id.button)
        button.setOnClickListener {
            // WorkoutInfoActivity로 이동
            val intent = Intent(this, WorkoutInfoActivity::class.java)
            startActivity(intent)
        }
    }
}
