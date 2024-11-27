package com.example.workoutdiary

import android.graphics.Color
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import kotlin.reflect.KMutableProperty0

class RoutineActivity : AppCompatActivity() {
    // 각 버튼에 대한 클릭 상태 추적 변수
    private var isChestClicked = false
    private var isSholderClicked = false
    private var isBackClicked = false
    private var isAbsClicked = false
    private var isArmClicked = false
    private var isLegClicked = false
    private var isHipClicked = false
    private var isAllClicked = false
    private var isCardioClicked = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_routine)

        //변수 초기화
        val saveButton = findViewById<Button>(R.id.saveButton)
        val titleTextView = findViewById<TextView>(R.id.titleTv)
        val routineNameTextView = findViewById<TextView>(R.id.routineNameTv)
        val routineEditText = findViewById<EditText>(R.id.routineET)
        val targetTextView = findViewById<TextView>(R.id.targetTv)
        val chestButton = findViewById<Button>(R.id.chestButton)
        val sholderButton = findViewById<Button>(R.id.sholderButton)
        val backButton = findViewById<Button>(R.id.backButton)
        val absButton = findViewById<Button>(R.id.absButton)
        val armButton = findViewById<Button>(R.id.armButton)
        val legButton = findViewById<Button>(R.id.legButton)
        val hipButton = findViewById<Button>(R.id.hipButton)
        val allButton = findViewById<Button>(R.id.allButton)
        val cardioButton = findViewById<Button>(R.id.cardioButton)
        val infoTextView = findViewById<TextView>(R.id.infoTv)
        val addButton = findViewById<Button>(R.id.addButton)


        // 입력값을 저장할 변수
        var routineText: String = ""

        // EditText 클릭 시 초기화
        routineEditText.setOnClickListener {
            routineEditText.text.clear() // EditText 내용 초기화
        }

        // 각 버튼의 클릭 리스너 설정
        chestButton.setOnClickListener {
            toggleButtonState(chestButton, ::isChestClicked)
        }
        sholderButton.setOnClickListener {
            toggleButtonState(sholderButton, ::isSholderClicked)
        }
        backButton.setOnClickListener {
            toggleButtonState(backButton, ::isBackClicked)
        }
        absButton.setOnClickListener {
            toggleButtonState(absButton, ::isAbsClicked)
        }
        armButton.setOnClickListener {
            toggleButtonState(armButton, ::isArmClicked)
        }
        legButton.setOnClickListener {
            toggleButtonState(legButton, ::isLegClicked)
        }
        hipButton.setOnClickListener {
            toggleButtonState(hipButton, ::isHipClicked)
        }
        allButton.setOnClickListener {
            toggleButtonState(allButton, ::isAllClicked)
        }
        cardioButton.setOnClickListener {
            toggleButtonState(cardioButton, ::isCardioClicked)
        }

    }
    // 버튼 클릭 상태를 토글하는 함수
    private fun toggleButtonState(button: Button, clickedState: KMutableProperty0<Boolean>) {
        if (clickedState.get()) {
            button.setBackgroundColor(Color.parseColor("#E7E5E5")) // 원래 배경색으로 설정
            button.setTextColor(Color.parseColor("#353232"))
        } else {
            button.setBackgroundColor(Color.parseColor("#2196F3")) // 클릭된 배경색으로 설정
            button.setTextColor(Color.WHITE)

        }
        clickedState.set(!clickedState.get()) // 상태 토글
    }

}