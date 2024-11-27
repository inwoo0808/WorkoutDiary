package com.example.workoutdiary

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        
        //layout 값 초기화
        val startButton = findViewById<Button>(R.id.startButton);

        startButton.setOnClickListener {
            // StatusActivity로 전환
            val intent = Intent(this, StatusActivity::class.java)
            startActivity(intent)
        }
    }
}