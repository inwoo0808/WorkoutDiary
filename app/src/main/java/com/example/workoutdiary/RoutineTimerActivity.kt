package com.example.workoutdiary

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.widget.Button
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity

class RoutineTimerActivity : AppCompatActivity() {

    private var hours = 0
    private var minutes = 0
    private var seconds = 0
    private var isRunning = true // 바로 실행되도록 true로 설정
    private val handler = Handler()
    private lateinit var timerRunnable: Runnable
    private lateinit var startStopButton: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_routinetimer)

        val timerTextView = findViewById<TextView>(R.id.timerTv)
        val titleTextView = findViewById<TextView>(R.id.titleTv)
        val setTextView = findViewById<TextView>(R.id.setTv)
        val endButton = findViewById<Button>(R.id.endButton)
        startStopButton = findViewById<Button>(R.id.stopButton)

        // 타이머 실행할 Runnable
        timerRunnable = Runnable {
            if (isRunning) {
                seconds++
                if (seconds == 60) {
                    seconds = 0
                    minutes++
                    if (minutes == 60) {
                        minutes = 0
                        hours++
                    }
                }

                val timeString = String.format("%02d:%02d:%02d", hours, minutes, seconds)
                timerTextView.text = timeString

                handler.postDelayed(timerRunnable, 1000) // 1초마다 실행
            }
        }

        // 타이머 바로 시작
        handler.postDelayed(timerRunnable, 1000)

        // 종료 버튼 클릭 이벤트 (다이얼로그 표시 후, 확인 시 이동)
        endButton.setOnClickListener {
            // 다이얼로그 생성
            val dialog = AlertDialog.Builder(this)
                .setTitle("운동을 종료하시겠습니까?")
                .setMessage("운동을 종료하면 현재까지의 기록은 저장되지 않습니다.")
                .setPositiveButton("확인") { _, _ ->
                    // 확인 버튼 클릭 시 IsRoutineActivity로 이동
                    val intent = Intent(this, IsRoutineActivity::class.java)
                    startActivity(intent)
                    finish() // 현재 액티비티 종료
                }
                .setNegativeButton("취소", null) // 취소 버튼 클릭 시 아무 일도 하지 않음
                .create()

            // 다이얼로그 표시
            dialog.show()
        }

        // 종료 버튼 클릭 이벤트 (타이머 정지 또는 재시작)
        startStopButton.setOnClickListener {
            if (isRunning) {
                // 타이머를 멈추고, 버튼 텍스트를 "재시작"으로 변경
                isRunning = false
                startStopButton.text = "재시작"
            } else {
                // 타이머를 재시작하고, 버튼 텍스트를 "정지"로 변경
                isRunning = true
                handler.postDelayed(timerRunnable, 1000)
                startStopButton.text = "정지"
            }
        }
    }
}
