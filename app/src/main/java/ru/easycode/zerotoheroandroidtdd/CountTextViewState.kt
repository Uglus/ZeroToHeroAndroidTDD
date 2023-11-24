package ru.easycode.zerotoheroandroidtdd

import android.widget.TextView
import java.io.Serializable

interface CountTextViewState : Serializable {
    fun apply(textView: TextView, incrementHelper: IncrementHelper)

    object Initial : CountTextViewState {

        override fun apply(textView: TextView, incrementHelper: IncrementHelper) = Unit

    }

    object Increment : CountTextViewState {
        override fun apply(textView: TextView, incrementHelper: IncrementHelper) {
            incrementHelper.doIncrement()
            textView.text = incrementHelper.getNumber().toString()
        }
    }

    object Restore : CountTextViewState {
        override fun apply(textView: TextView, incrementHelper: IncrementHelper) {
            textView.text = incrementHelper.getNumber().toString()
        }
    }
}