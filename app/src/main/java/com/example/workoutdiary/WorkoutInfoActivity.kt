package com.example.workoutdiary

import android.content.Intent
import android.os.Bundle
import android.text.InputType
import android.view.Gravity
import android.widget.*
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat

class WorkoutInfoActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_workout_info)

        val setListContainer = findViewById<LinearLayout>(R.id.set_list_container)
        val addSetButton = findViewById<Button>(R.id.button_add_set)
        val saveButton = findViewById<Button>(R.id.button_save)
        val exerciseNameInput = findViewById<EditText>(R.id.edittext_exercise_name)

        // Button들
        val buttonWeightReps = findViewById<Button>(R.id.button_weight_reps)
        val buttonRepsOnly = findViewById<Button>(R.id.button_reps_only)
        val buttonTime = findViewById<Button>(R.id.button_time)

        var showWeight = true
        var showReps = true
        var showTime = false

        // 기본적으로 '무게, 개수' 버튼이 눌려있는 상태로 설정
        setButtonState(buttonWeightReps, buttonRepsOnly, buttonTime)
        updateSetItemLayout(setListContainer, showWeight, showReps, showTime)

        // 버튼 클릭 시 세트 항목 레이아웃 변경
        buttonWeightReps.setOnClickListener {
            // 버튼 색상 상태 변경
            setButtonState(buttonWeightReps, buttonRepsOnly, buttonTime)

            showWeight = true
            showReps = true
            showTime = false
            updateSetItemLayout(setListContainer, showWeight, showReps, showTime)
        }

        buttonRepsOnly.setOnClickListener {
            // 버튼 색상 상태 변경
            setButtonState(buttonRepsOnly, buttonWeightReps, buttonTime)

            showWeight = false
            showReps = true
            showTime = false
            updateSetItemLayout(setListContainer, showWeight, showReps, showTime)
        }

        buttonTime.setOnClickListener {
            // 버튼 색상 상태 변경
            setButtonState(buttonTime, buttonWeightReps, buttonRepsOnly)

            showWeight = false
            showReps = false
            showTime = true
            updateSetItemLayout(setListContainer, showWeight, showReps, showTime)
        }

        saveButton.setOnClickListener {
            val exerciseName = exerciseNameInput.text.toString()
            if (exerciseName.isBlank()) {
                Toast.makeText(this, "운동 이름을 입력해주세요!", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            val sets = ArrayList<String>()
            for (i in 0 until setListContainer.childCount) {
                val setItem = setListContainer.getChildAt(i) as LinearLayout
                val weightInput = setItem.findViewById<EditText>(R.id.input_weight)
                val repsInput = setItem.findViewById<EditText>(R.id.input_reps)

                val weight = weightInput?.text?.toString()?.ifBlank { "0" } ?: "0"
                val reps = repsInput?.text?.toString()?.ifBlank { "0" } ?: "0"
                sets.add("${weight}kg x ${reps}개")
            }

            val intent = Intent()
            val newItem = Pair(exerciseName, sets.size.toString())
            intent.putExtra("routineItems", newItem)
            setResult(RESULT_OK, intent)
            finish()
        }

        // 기본 레이아웃 설정
        addSetButton.setOnClickListener {
            addSetItem(setListContainer, showWeight, showReps, showTime)
        }
    }


    private fun setButtonState(activeButton: Button, vararg inactiveButtons: Button) {
        // 활성화된 버튼 색상 변경
        activeButton.setBackgroundColor(ContextCompat.getColor(this, R.color.active_button_color)) // 활성화 색상
        activeButton.setTextColor(ContextCompat.getColor(this, R.color.active_text_color)) // 텍스트 색상

        // 비활성화된 버튼 색상 원래대로 복원
        for (button in inactiveButtons) {
            button.setBackgroundColor(ContextCompat.getColor(this, R.color.inactive_button_color)) // 비활성화 색상
            button.setTextColor(ContextCompat.getColor(this, R.color.inactive_text_color)) // 텍스트 색상
        }
    }

    private fun updateSetItemLayout(container: LinearLayout, showWeight: Boolean, showReps: Boolean, showTime: Boolean) {
        container.removeAllViews()
        addSetItem(container, showWeight, showReps, showTime)
    }

    private fun addSetItem(container: LinearLayout, showWeight: Boolean, showReps: Boolean, showTime: Boolean) {
        val setItem = LinearLayout(this).apply {
            orientation = LinearLayout.HORIZONTAL
            gravity = Gravity.CENTER_VERTICAL
            layoutParams = LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.MATCH_PARENT,
                LinearLayout.LayoutParams.WRAP_CONTENT
            ).apply { setMargins(0, 16, 0, 16) }
        }

        val setText = TextView(this).apply {
            text = "${container.childCount + 1} 세트"
            layoutParams = LinearLayout.LayoutParams(0, LinearLayout.LayoutParams.WRAP_CONTENT, 1f)
        }
        setItem.addView(setText)

        if (showWeight) {
            val weightInput = EditText(this).apply {
                hint = "무게 (kg)"
                inputType = InputType.TYPE_CLASS_NUMBER or InputType.TYPE_NUMBER_FLAG_DECIMAL
                layoutParams = LinearLayout.LayoutParams(0, LinearLayout.LayoutParams.WRAP_CONTENT, 2f)
                id = R.id.input_weight // ID 추가
            }
            setItem.addView(weightInput)
        }

        if (showReps) {
            val repsInput = EditText(this).apply {
                hint = "개수"
                inputType = InputType.TYPE_CLASS_NUMBER
                layoutParams = LinearLayout.LayoutParams(0, LinearLayout.LayoutParams.WRAP_CONTENT, 2f)
                id = R.id.input_reps // ID 추가
            }
            setItem.addView(repsInput)
        }

        if (showTime) {
            val timeInput = EditText(this).apply {
                hint = "시간 (초)"
                inputType = InputType.TYPE_CLASS_NUMBER
                layoutParams = LinearLayout.LayoutParams(0, LinearLayout.LayoutParams.WRAP_CONTENT, 2f)
                id = R.id.input_reps // ID 추가
            }
            setItem.addView(timeInput)
        }

        val deleteButton = Button(this).apply {
            text = "삭제"
            setOnClickListener { container.removeView(setItem) }
        }
        setItem.addView(deleteButton)

        container.addView(setItem)
    }
}
