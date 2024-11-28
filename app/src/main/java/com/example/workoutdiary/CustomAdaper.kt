package com.example.workoutdiary

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.TextView

class CustomAdapter(context: Context, private val sets: List<String>) : BaseAdapter() {

    private val inflater: LayoutInflater = LayoutInflater.from(context)

    override fun getCount(): Int {
        return sets.size
    }

    override fun getItem(position: Int): Any {
        return sets[position]
    }

    override fun getItemId(position: Int): Long {
        return position.toLong()
    }

    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        val view: View = convertView ?: inflater.inflate(R.layout.list_workout, parent, false)

        val setTextView = view.findViewById<TextView>(R.id.textView)
        setTextView.text = sets[position]

        return view
    }
}
