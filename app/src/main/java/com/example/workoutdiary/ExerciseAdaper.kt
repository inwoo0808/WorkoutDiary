package com.example.workoutdiary

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.BaseAdapter
import android.widget.Button
import android.widget.ListView
import android.widget.TextView
import android.widget.Toast

class ExerciseAdapter(
    private val context: Context,
    private val exercises: List<Exercise>
) : BaseAdapter() {

    override fun getCount(): Int = exercises.size

    override fun getItem(position: Int): Any = exercises[position]

    override fun getItemId(position: Int): Long = position.toLong()

    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        val view = convertView ?: LayoutInflater.from(context).inflate(R.layout.list_workout, parent, false)

        val exerciseNameTextView = view.findViewById<TextView>(R.id.textview_exercise_name)
        val setsListView = view.findViewById<ListView>(R.id.listview_sets)
        val editButton = view.findViewById<Button>(R.id.btn_edit)
        val deleteButton = view.findViewById<Button>(R.id.btn_delete)

        val exercise = exercises[position]

        // 운동 이름 설정
        exerciseNameTextView.text = exercise.name

        // 세트 데이터 설정
        val setsAdapter = ArrayAdapter(context, android.R.layout.activity_list_item, exercise.sets)
        setsListView.adapter = setsAdapter

        // 버튼 클릭 이벤트 처리
        editButton.setOnClickListener {
            // 수정 버튼 클릭 시 동작 추가
            // 예: Toast 메시지
            Toast.makeText(context, "${exercise.name} 수정 클릭", Toast.LENGTH_SHORT).show()
        }

        deleteButton.setOnClickListener {
            // 삭제 버튼 클릭 시 동작 추가
            // 예: Toast 메시지
            Toast.makeText(context, "${exercise.name} 삭제 클릭", Toast.LENGTH_SHORT).show()
        }

        return view
    }
}
