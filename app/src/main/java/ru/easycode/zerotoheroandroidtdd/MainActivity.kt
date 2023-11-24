package ru.easycode.zerotoheroandroidtdd

import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    private var count: Count = Count.Base(step = 2)
    private var numberData = NumberData(number = 0)
    private var countTextViewState: CountTextViewState = CountTextViewState.Initial
    private lateinit var countTextView: TextView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        countTextView = findViewById(R.id.countTextView)

        val incrementButton: Button = findViewById(R.id.incrementButton)
        incrementButton.setOnClickListener {
            countTextViewState = CountTextViewState.Increment
            countTextViewState.apply(
                textView = countTextView,
                count = count,
                numberData = numberData
            )
        }
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putSerializable(INCREMENT_KEY, numberData)
    }

    override fun onRestoreInstanceState(savedInstanceState: Bundle) {
        super.onRestoreInstanceState(savedInstanceState)
        numberData = if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU) {
            savedInstanceState.getSerializable(
                INCREMENT_KEY,
                numberData::class.java
            ) as NumberData
        } else
            savedInstanceState.getSerializable(INCREMENT_KEY) as NumberData

        countTextViewState = CountTextViewState.Restore
        countTextViewState.apply(textView = countTextView, count = count, numberData = numberData)
    }

    companion object {
        private const val INCREMENT_KEY = "increment_key"
    }

}