package com.geeks.nurkyz_chomoeva_hw3_5

import android.graphics.Color
import android.os.Bundle
import android.widget.Button
import android.widget.LinearLayout
import android.widget.ScrollView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    private var state = true

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val colorChangeButton = findViewById<Button>(R.id.colorChangeButton)
        val chatLayout = findViewById<LinearLayout>(R.id.chatLayout)
        val chatScrollView = findViewById<ScrollView>(R.id.chatScrollView)

        colorChangeButton.setOnClickListener {

            val messageTextView = TextView(this)
            messageTextView.text = "Новое сообщение"
            messageTextView.textSize = 18f
            messageTextView.setPadding(16, 16, 16, 16)
            messageTextView.setTextColor(Color.WHITE)

            if (state) {
                colorChangeButton.setBackgroundColor(Color.GREEN)
                messageTextView.setBackgroundColor(Color.BLUE)
            } else {
                colorChangeButton.setBackgroundColor(Color.BLUE)
                messageTextView.setBackgroundColor(Color.GREEN)
            }
            state = !state

            chatLayout.addView(messageTextView)

            chatScrollView.post {
                chatScrollView.fullScroll(ScrollView.FOCUS_DOWN)
            }
        }
    }
}