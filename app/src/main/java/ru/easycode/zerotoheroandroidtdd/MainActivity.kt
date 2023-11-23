package ru.easycode.zerotoheroandroidtdd

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.LinearLayout
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    private lateinit var titleTextView: TextView
    private lateinit var rootLayout: LinearLayout
    private var state : State = State.Initial
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        titleTextView = findViewById(R.id.titleTextView)
        val removeButton: Button = findViewById(R.id.removeButton)
        rootLayout = findViewById(R.id.rootLayout)

        removeButton.setOnClickListener {
            state = State.Removed
            state.apply(linearLayout = rootLayout, textView = titleTextView)
        }


    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putSerializable(KEY, state)
    }

    override fun onRestoreInstanceState(savedInstanceState: Bundle) {
        super.onRestoreInstanceState(savedInstanceState)
        state = savedInstanceState.getSerializable(KEY) as State
        state.apply(linearLayout = rootLayout, textView = titleTextView)
    }

    companion object {
        private const val KEY = "key"
    }
}