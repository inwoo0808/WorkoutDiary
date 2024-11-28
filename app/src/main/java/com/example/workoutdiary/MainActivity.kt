package com.example.workoutdiary

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)


            val nickname = findViewById<EditText>(R.id.nicknameET)
            val startButton = findViewById<Button>(R.id.startButton)

            startButton.setOnClickListener {
                // nickname 입력값 가져오기
                val nicknameText = nickname.text.toString()

                // 입력값이 비어있지 않으면 Toast 띄우기
                if (nicknameText.isNotEmpty()) {
                    Toast.makeText(this, "환영합니다, $nicknameText!", Toast.LENGTH_SHORT).show()

                    // StatusActivity로 전환
                    val intent = Intent(this, StatusActivity::class.java)
                    startActivity(intent)
                } else {
                    // 입력값이 비어있다면 경고 메시지 표시
                    Toast.makeText(this, "닉네임을 입력해주세요.", Toast.LENGTH_SHORT).show()
                }

        }
    }
}
