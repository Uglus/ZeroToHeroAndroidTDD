package ru.easycode.zerotoheroandroidtdd

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import androidx.core.view.isVisible

class MainActivity : AppCompatActivity() {
    private lateinit var titleTextView: TextView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        titleTextView = findViewById(R.id.titleTextView)
        initHideButton()
    }

    private fun initHideButton() {
        val hideButton: Button = findViewById(R.id.hideButton)
        hideButton.setOnClickListener {
            if (titleTextView.isVisible)
                titleTextView.visibility = View.GONE
            else
                titleTextView.visibility = View.VISIBLE
        }
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putInt(TITLE_VISIBILITY_KEY, titleTextView.visibility)
    }

    override fun onRestoreInstanceState(savedInstanceState: Bundle) {
        super.onRestoreInstanceState(savedInstanceState)
        titleTextView.visibility = savedInstanceState.getInt(TITLE_VISIBILITY_KEY)

    }

    companion object {
        private const val TITLE_VISIBILITY_KEY = "titleVisibilityKey"
    }
}