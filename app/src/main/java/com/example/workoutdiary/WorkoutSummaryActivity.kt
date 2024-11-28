package com.example.workoutdiary

import android.os.Bundle
import android.view.View
import android.widget.ListView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class WorkoutSummaryActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_workout_item) // 수정된 레이아웃 이름

        val exerciseNameTextView = findViewById<TextView>(R.id.textview_exercise_name)
        val setsListView = findViewById<ListView>(R.id.listview_sets)

        // Intent로 받아온 데이터
        val exerciseName = intent.getStringExtra("exerciseName") ?: "운동 이름 없음"
        val sets = intent.getStringArrayListExtra("sets") ?: arrayListOf()

        // 운동 이름 설정
        exerciseNameTextView.text = exerciseName

        // CustomAdapter를 사용하여 ListView 설정
        val adapter = CustomAdapter(this, sets)
        setsListView.adapter = adapter

        // ListView 초기 상태를 GONE으로 설정하여 숨김
        setsListView.visibility = View.GONE

        // TextView 클릭 이벤트 설정
        exerciseNameTextView.setOnClickListener {
            // ListView의 가시성을 토글
            setsListView.visibility = if (setsListView.visibility == View.GONE) {
                View.VISIBLE
            } else {
                View.GONE
            }
        }
    }
}
