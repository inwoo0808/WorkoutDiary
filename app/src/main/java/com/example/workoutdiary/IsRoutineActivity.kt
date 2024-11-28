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
    private val items = mutableListOf<ListViewItem>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_isroutine)

        val timerTextView = findViewById<TextView>(R.id.timerTv)
        val startButton = findViewById<Button>(R.id.startButton)
        val startTextView = findViewById<TextView>(R.id.startTv)
        val routineNameTextView = findViewById<TextView>(R.id.routineNameTv)

        val listView = findViewById<ListView>(R.id.routineList)

        // 카테고리 데이터
        val categories: ArrayList<String> = intent.getStringArrayListExtra("categories") ?: ArrayList<String>()
        val categoryString = categories.joinToString(", ")

        // routineName이 null일 경우 처리
        val routineName = intent.getStringExtra("routineName") ?: "루틴 이름 없음"

        // routineItems 데이터 받기
        val routineItems = intent.getSerializableExtra("routineItems") as ArrayList<Pair<String, String>>

        routineNameTextView.text = routineName

        for (item in routineItems) {
            items.add(ListViewItem(item.first, categoryString, item.second))
        }

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
                // RoutineActivity로 이동 (결과를 받기 위해 startActivityForResult 사용)
                val intent = Intent(this@IsRoutineActivity, RoutineActivity::class.java)
                startActivityForResult(intent, 100) // 결과를 받을 수 있도록 requestCode를 설정
                dialog.dismiss()
            }
            setNegativeButton("취소") { dialog, _ ->
                // 다이얼로그 닫기
                dialog.dismiss()
            }
        }.create().show()
    }


    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        if (requestCode == 100 && resultCode == RESULT_OK) {
            // RoutineActivity에서 돌아온 결과로 새로운 루틴 데이터 받기
            val addedRoutineItems = data?.getSerializableExtra("routineItems") as? ArrayList<Pair<String, String>>
            val routineName = data?.getStringExtra("routineName") ?: "새 루틴"
            val categories = data?.getStringArrayListExtra("categories") ?: ArrayList<String>()
            val categoryString = categories.joinToString(", ")

            // 새로 추가된 루틴을 기존 아이템에 추가
            addedRoutineItems?.forEach { item ->
                items.add(ListViewItem(routineName, categoryString, item.second))
            }

            // 어댑터에서 notifyDataSetChanged 호출하여 ListView 갱신
            (findViewById<ListView>(R.id.routineList).adapter as ListViewAdapter).notifyDataSetChanged()
        }
    }
}