package ru.easycode.zerotoheroandroidtdd

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.LinearLayout
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    var removeTextViewState: RemoveTextViewState = RemoveTextViewState.Initial
    var disabledViewState: DisabledViewState = DisabledViewState.Initial

    private lateinit var rootLayout : LinearLayout
    private lateinit var titleTextView : TextView
    private lateinit var removeButton : Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        rootLayout = findViewById(R.id.rootLayout)
        titleTextView = findViewById(R.id.titleTextView)
        removeButton = findViewById(R.id.removeButton)

        removeButton.setOnClickListener {
            removeTextViewState = RemoveTextViewState.Removed
            removeTextViewState.apply(linearLayout = rootLayout, textView = titleTextView)
            disabledViewState = DisabledViewState.Disabled
            disabledViewState.apply(removeButton)
        }


    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putSerializable(IS_REMOVED_TITLE_KEY,removeTextViewState)
        outState.putSerializable(IS_DISABLED_REMOVE_BUTTON_KEY,disabledViewState)
    }

    override fun onRestoreInstanceState(savedInstanceState: Bundle) {
        super.onRestoreInstanceState(savedInstanceState)
        disabledViewState = savedInstanceState.getSerializable(IS_DISABLED_REMOVE_BUTTON_KEY) as DisabledViewState
        disabledViewState.apply(removeButton)

        removeTextViewState = savedInstanceState.getSerializable(IS_REMOVED_TITLE_KEY) as RemoveTextViewState
        removeTextViewState.apply(linearLayout = rootLayout, textView = titleTextView)
    }

    companion object {
        private const val IS_REMOVED_TITLE_KEY = "removedTitle"
        private const val IS_DISABLED_REMOVE_BUTTON_KEY = "disabledRemoveButton"
    }

}