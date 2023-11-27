package ru.easycode.zerotoheroandroidtdd

import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    private val count = Count.Base(step = 2, max = 4)
    private var uiState: UiState = UiState.Base(text = "0")
    private lateinit var countTextView: TextView
    private lateinit var incrementButton: Button


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        countTextView = findViewById(R.id.countTextView)
        incrementButton = findViewById(R.id.incrementButton)
        incrementButton.setOnClickListener {
            val data: String = countTextView.text.toString()
            uiState = count.increment(number = data)
            uiState.apply(textView = countTextView, button = incrementButton)
        }
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putSerializable(STATE_KEY,uiState)
    }

    override fun onRestoreInstanceState(savedInstanceState: Bundle) {
        super.onRestoreInstanceState(savedInstanceState)
        uiState = if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU) {
            savedInstanceState.getSerializable(STATE_KEY, UiState::class.java) as UiState
        } else {
            savedInstanceState.getSerializable(STATE_KEY) as UiState
        }
        uiState.apply(textView = countTextView,button = incrementButton)
    }

    companion object{
        private const val STATE_KEY : String = "state_key_bundle"
    }



}