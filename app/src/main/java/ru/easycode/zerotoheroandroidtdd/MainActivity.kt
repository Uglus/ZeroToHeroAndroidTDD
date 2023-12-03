package ru.easycode.zerotoheroandroidtdd

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ProgressBar
import android.widget.TextView

class MainActivity : AppCompatActivity() {

    private val mainViewModel: MainViewModel =
        MainViewModel(liveDataWrapper = LiveDataWrapper.Base(), repository = Repository.Base())

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val titleTextView: TextView = findViewById(R.id.titleTextView)
        val progressBar: ProgressBar = findViewById(R.id.progressBar)
        val actionButton: Button = findViewById(R.id.actionButton)

        actionButton.setOnClickListener {
            mainViewModel.load()
        }

        mainViewModel.liveData().observe(this) { uiState ->
            uiState.apply(
                button = actionButton,
                progressBar = progressBar,
                textView = titleTextView
            )

        }
    }
}