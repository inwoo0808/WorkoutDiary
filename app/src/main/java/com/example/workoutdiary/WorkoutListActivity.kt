package com.example.workoutdiary

import android.os.Bundle
import android.widget.ListView
import androidx.appcompat.app.AppCompatActivity
import com.example.workoutdiary.R

class WorkoutListActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.list_workout)

        val listView: ListView = findViewById(R.id.list_view_exercises)

        // 샘플 데이터
        val exercises = listOf(
            Exercise("벤치 프레스", listOf("세트 1: 10회", "세트 2: 8회")),
            Exercise("스쿼트", listOf("세트 1: 12회", "세트 2: 10회", "세트 3: 8회")),
            Exercise("데드리프트", listOf("세트 1: 8회", "세트 2: 8회"))
        )

        val adapter = ExerciseAdapter(this, exercises)
        listView.adapter = adapter
    }
}