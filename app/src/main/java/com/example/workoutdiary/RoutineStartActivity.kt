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

        val routineTitle = intent.getStringExtra("routineTitle") ?: "기본 제목"
        val routine = intent.getStringExtra("routine") ?: "기본 루틴"
        val count = intent.getStringExtra("count") ?: "기본 세트"

        // 받은 데이터를 TextView에 설정
        titleTextView.text = routineTitle
        setTextView.text = count

        startButton.setOnClickListener {
            val intent = Intent(this, RoutineTimerActivity::class.java)
            intent.putExtra("routineTitle", routineTitle)
            intent.putExtra("routine", routine)
            intent.putExtra("count", count)
            startActivity(intent)
        }

    }

}

