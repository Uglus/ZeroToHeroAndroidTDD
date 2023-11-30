package ru.easycode.zerotoheroandroidtdd

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.ProgressBar
import android.widget.TextView
import androidx.core.view.isVisible

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val titleTextView : TextView = findViewById(R.id.titleTextView)
        val progressBar : ProgressBar = findViewById(R.id.progressBar)
        val actionButton : Button = findViewById(R.id.actionButton)


        actionButton.setOnClickListener {
            actionButton.isEnabled = false
            progressBar.isVisible = true
            actionButton.postDelayed({
                progressBar.visibility = View.GONE
                actionButton.isEnabled = true
                titleTextView.visibility = View.VISIBLE
            },3500)
        }

    }
}