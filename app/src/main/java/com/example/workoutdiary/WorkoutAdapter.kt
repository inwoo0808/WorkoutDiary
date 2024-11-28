package com.example.workoutdiary

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import android.widget.BaseAdapter

class WorkoutAdapter(private val context: Context, private val data: List<String>) : BaseAdapter() {

    override fun getCount(): Int = data.size

    override fun getItem(position: Int): Any = data[position]

    override fun getItemId(position: Int): Long = position.toLong()

    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        val view = convertView ?: LayoutInflater.from(context)
            .inflate(R.layout.activity_workout_item, parent, false)

        val workoutText = view.findViewById<TextView>(R.id.textView)
        val editButton = view.findViewById<Button>(R.id.btn_edit)
        val deleteButton = view.findViewById<Button>(R.id.btn_delete)

        workoutText.text = data[position]

        editButton.setOnClickListener {
            Toast.makeText(context, "${data[position]} 수정", Toast.LENGTH_SHORT).show()
        }

        deleteButton.setOnClickListener {
            Toast.makeText(context, "${data[position]} 삭제", Toast.LENGTH_SHORT).show()
        }

        return view
    }
}