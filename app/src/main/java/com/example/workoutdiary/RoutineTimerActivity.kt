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

    private var minutes2 = 0
    private var seconds2 = 0
    private var isRunning2 = false
    private lateinit var timerRunnable2: Runnable

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_routinetimer)

        val timerTextView = findViewById<TextView>(R.id.timerTv)
        val titleTextView = findViewById<TextView>(R.id.titleTv)
        val setTextView = findViewById<TextView>(R.id.setTv)
        val endButton = findViewById<Button>(R.id.endButton)
        startStopButton = findViewById<Button>(R.id.stopButton)

        val timerTextView2 = findViewById<TextView>(R.id.timerTv2)

        val addButton1 = findViewById<Button>(R.id.addButton1)
        val addButton2 = findViewById<Button>(R.id.addButton2)
        val addButton3 = findViewById<Button>(R.id.addButton3)
        val addButton4 = findViewById<Button>(R.id.addButton4)

        val resetButton = findViewById<Button>(R.id.resetButton)
        val startButton = findViewById<Button>(R.id.startButton)

        // RoutineStartActivity에서 전달한 데이터 받기
        val routineTitle = intent.getStringExtra("routineTitle") ?: "기본 제목"
        val routine = intent.getStringExtra("routine") ?: "기본 루틴"
        val count = intent.getStringExtra("count") ?: "기본 세트"

        // 받은 데이터를 TextView에 설정
        titleTextView.text = routineTitle
        setTextView.text = count

        endButton.setOnClickListener {
            val intent = Intent(this, IsRoutineActivity::class.java)
            startActivity(intent)
        }

        // 타이머 1 (정상 동작 유지)
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

                handler.postDelayed(timerRunnable, 1000)
            }
        }

        // 타이머 바로 시작
        handler.postDelayed(timerRunnable, 1000)

        startStopButton.setOnClickListener {
            if (isRunning) {
                isRunning = false
                startStopButton.text = "재시작"
            } else {
                isRunning = true
                handler.postDelayed(timerRunnable, 1000)
                startStopButton.text = "정지"
            }
        }

        // 타이머 2 (카운트다운)
        timerRunnable2 = Runnable {
            if (isRunning2) {
                if (seconds2 == 0 && minutes2 == 0) {
                    isRunning2 = false
                    timerTextView2.text = "00:00"
                } else {
                    if (seconds2 == 0) {
                        minutes2--
                        seconds2 = 59
                    } else {
                        seconds2--
                    }
                    updateTimerDisplay(timerTextView2, minutes2, seconds2)
                    handler.postDelayed(timerRunnable2, 1000)
                }
            }
        }

        startButton.setOnClickListener {
            if (isRunning2) {
                isRunning2 = false
                startButton.text = "시작"
            } else {
                isRunning2 = true
                handler.postDelayed(timerRunnable2, 1000)
                startButton.text = "정지"
            }
        }

        resetButton.setOnClickListener {
            isRunning2 = false
            minutes2 = 0 // 초기 시간(분)을 다시 설정
            seconds2 = 0
            updateTimerDisplay(timerTextView2, minutes2, seconds2)
            startButton.text = "시작"
        }

        // Add 버튼 (타이머 2에만 적용)
        addButton1.setOnClickListener { minutes2 += 1; updateTimerDisplay(timerTextView2, minutes2, seconds2) }
        addButton2.setOnClickListener { seconds2 += 30; normalizeTime(2); updateTimerDisplay(timerTextView2, minutes2, seconds2) }
        addButton3.setOnClickListener { seconds2 += 10; normalizeTime(2); updateTimerDisplay(timerTextView2, minutes2, seconds2) }
        addButton4.setOnClickListener { seconds2 += 5; normalizeTime(2); updateTimerDisplay(timerTextView2, minutes2, seconds2) }
    }

    private fun normalizeTime(timer: Int) {
        if (timer == 2) {
            if (seconds2 >= 60) {
                minutes2 += seconds2 / 60
                seconds2 %= 60
            }
        }
    }

    private fun updateTimerDisplay(timerTextView: TextView, minutes: Int, seconds: Int) {
        timerTextView.text = String.format("%02d:%02d", minutes, seconds)
    }
}
