package ru.easycode.zerotoheroandroidtdd

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.LinearLayout
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    private var removeTitleTextView: RemoveTitleTextView = RemoveTitleTextView.Initial // щоб не писати null

    private lateinit var rootLayout: LinearLayout
    private lateinit var titleTextView: TextView
    private lateinit var removeButton: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        rootLayout = findViewById(R.id.rootLayout)
        titleTextView = findViewById(R.id.titleTextView)
        removeButton = findViewById(R.id.removeButton)

        removeButton.setOnClickListener {
            removeTitleTextView = RemoveTitleTextView.Removed
            removeTitleTextView.apply(
                linearLayout = rootLayout,
                textView = titleTextView,
                button = removeButton
            )
        }


    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putSerializable(IS_REMOVED_TITLE_KEY, removeTitleTextView)
    }

    override fun onRestoreInstanceState(savedInstanceState: Bundle) {
        super.onRestoreInstanceState(savedInstanceState)
        removeTitleTextView =
            savedInstanceState.getSerializable(IS_REMOVED_TITLE_KEY) as RemoveTitleTextView
        removeTitleTextView.apply(
            linearLayout = rootLayout,
            textView = titleTextView,
            button = removeButton
        )
    }

    companion object {
        private const val IS_REMOVED_TITLE_KEY = "removedTitle"
    }

}