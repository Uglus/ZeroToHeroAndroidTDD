package ru.easycode.zerotoheroandroidtdd

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.LinearLayout
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    private lateinit var titleTextView: TextView
    private lateinit var rootLayout:LinearLayout
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        titleTextView = findViewById(R.id.titleTextView)
        val removeButton : Button = findViewById(R.id.removeButton)
        rootLayout = findViewById(R.id.rootLayout)

        removeButton.setOnClickListener {
            rootLayout.removeView(titleTextView)
        }



    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        val isTitleRemoved = rootLayout.childCount == 1
        outState.putBoolean(KEY,isTitleRemoved)
    }

    override fun onRestoreInstanceState(savedInstanceState: Bundle) {
        super.onRestoreInstanceState(savedInstanceState)
        val isTitleRemoved = savedInstanceState.getBoolean(KEY)
        if(isTitleRemoved)
            rootLayout.removeView(titleTextView)
    }

    companion object {
        private const val KEY = "key"
    }
}