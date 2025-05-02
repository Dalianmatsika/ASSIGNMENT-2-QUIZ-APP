package com.example.quizapp

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class ScoreActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_score)

        // Initialize UI elements
        val scoreText: TextView = findViewById(R.id.scoreText)
        val feedbackTextView: TextView = findViewById(R.id.feedbackText)
        val reviewButton: Button = findViewById(R.id.reviewButton)
        val exitButton: Button = findViewById(R.id.exitButton)

        // Get the score from the intent.
        val score = intent.getIntExtra("score", 0)

        // Display the user's score.
        scoreText.text = "Your Score: $score out of ${5}"  // Corrected string interpolation

        // Provide feedback based on the score.
        val feedback = when {
            score >= 3 -> "Great job!"
            else -> "Keep practising!"
        }
        feedbackTextView.text = feedback

        // Set a click listener for the review button.
        reviewButton.setOnClickListener {
            // Create an intent to open the ReviewActivity.
            val intent = Intent(this, ReviewActivity::class.java)
            startActivity(intent)
        }

        // Set a click listener for the exit button.
        exitButton.setOnClickListener {
            // Finish the current activity.  This will effectively exit the app.
            finishAffinity() // Use finishAffinity to close the entire app.
        }
    }
}