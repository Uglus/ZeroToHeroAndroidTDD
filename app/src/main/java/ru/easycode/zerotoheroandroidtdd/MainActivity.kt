package ru.easycode.zerotoheroandroidtdd

import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    private var incrementHelper: IncrementHelper = IncrementHelper()
    private var countTextViewState: CountTextViewState = CountTextViewState.Initial
    private lateinit var countTextView: TextView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        countTextView = findViewById(R.id.countTextView)

        val incrementButton: Button = findViewById(R.id.incrementButton)
        incrementButton.setOnClickListener {
            countTextViewState = CountTextViewState.Increment
            countTextViewState.apply(countTextView, incrementHelper)
        }
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putSerializable(INCREMENT_KEY, incrementHelper)
    }

    override fun onRestoreInstanceState(savedInstanceState: Bundle) {
        super.onRestoreInstanceState(savedInstanceState)
        incrementHelper = if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU) {
            savedInstanceState.getSerializable(
                INCREMENT_KEY,
                incrementHelper::class.java
            ) as IncrementHelper
        } else
            savedInstanceState.getSerializable(INCREMENT_KEY) as IncrementHelper

        countTextViewState = CountTextViewState.Restore
        countTextViewState.apply(textView = countTextView, incrementHelper = incrementHelper)
    }

    companion object {
        private const val INCREMENT_KEY = "increment_key"
    }

}