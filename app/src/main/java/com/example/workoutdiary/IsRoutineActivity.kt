package com.example.workoutdiary

import ListViewAdapter
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.ListView
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity

class IsRoutineActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_isroutine)

        val timerTextView = findViewById<TextView>(R.id.timerTv)
        val startButton = findViewById<Button>(R.id.startButton)
        val startTextView = findViewById<TextView>(R.id.startTv)

        val listView = findViewById<ListView>(R.id.routineList)

        val items = mutableListOf<ListViewItem>()

        items.add(ListViewItem("가슴 루틴", "가슴", "운동 5개"))
        items.add(ListViewItem("가슴 루틴", "가슴", "운동 5개"))
        items.add(ListViewItem("가슴 루틴", "가슴", "운동 5개"))

        val adapter = ListViewAdapter(items)
        listView.adapter = adapter

        // Start 버튼 클릭 리스너 설정
        startButton.setOnClickListener {
            showAddRoutineDialog()
        }

    }

    private fun showAddRoutineDialog() {
        // 다이얼로그 빌더 생성
        AlertDialog.Builder(this).apply {
            setTitle("루틴 추가")
            setMessage("루틴을 추가해보세요!")
            setPositiveButton("확인") { dialog, _ ->
                // RoutineActivity로 이동
                val intent = Intent(this@IsRoutineActivity, RoutineActivity::class.java)
                startActivity(intent)
                dialog.dismiss()
            }
            setNegativeButton("취소") { dialog, _ ->
                // 다이얼로그 닫기
                dialog.dismiss()
            }
        }.create().show()
    }
}