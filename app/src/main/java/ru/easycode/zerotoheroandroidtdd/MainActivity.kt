package ru.easycode.zerotoheroandroidtdd

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    private var state: UiState = UiState.Base(text = "0")
    private var count: Count = Count.Base(step = 2, max = 4, min = 0)
    private lateinit var countTextView: TextView
    private lateinit var incrementButton: Button
    private lateinit var decrementButton: Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initViews()
    }

    private fun initViews() {
        countTextView = findViewById(R.id.countTextView)
        incrementButton = findViewById(R.id.incrementButton)
        decrementButton = findViewById(R.id.decrementButton)
        initClickOnButtons()
        decrementButton.isEnabled = false
    }

    private fun initClickOnButtons() {
        var data = "0"
        incrementButton.setOnClickListener {
            data = countTextView.text.toString()
            state = count.increment(number = data)
            state.apply(
                textView = countTextView,
                incrementButton = incrementButton,
                decrementButton = decrementButton
            )
        }
        decrementButton.setOnClickListener {
            data = countTextView.text.toString()
            state = count.decrement(number = data)
            state.apply(
                textView = countTextView,
                incrementButton = incrementButton,
                decrementButton = decrementButton
            )
        }
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        state = count.initial(number = countTextView.text.toString())
        outState.putSerializable(NUMBER_KEY, state)
    }

    override fun onRestoreInstanceState(savedInstanceState: Bundle) {
        super.onRestoreInstanceState(savedInstanceState)
        //state = savedInstanceState.getSerializable(NUMBER_KEY,UiState::class.java) as UiState
        state = savedInstanceState.getSerializable(NUMBER_KEY) as UiState
        state.apply(
            textView = countTextView,
            incrementButton = incrementButton,
            decrementButton = decrementButton
        )

    }

    companion object {
        private const val NUMBER_KEY = "number_key"
    }
}