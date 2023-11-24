package ru.easycode.zerotoheroandroidtdd

import android.widget.TextView
import java.io.Serializable

interface CountTextViewState : Serializable {
    fun apply(textView: TextView, count: Count, numberData: NumberData)

    object Initial : CountTextViewState {

        override fun apply(textView: TextView, count: Count, numberData: NumberData) = Unit

    }

    object Increment : CountTextViewState {
        override fun apply(textView: TextView, count: Count, numberData: NumberData) {
            numberData.number = count.increment(numberData.number.toString()).toInt()
            textView.text = numberData.number.toString()
        }
    }

    object Restore : CountTextViewState {
        override fun apply(textView: TextView, count: Count, numberData: NumberData) {
            textView.text = numberData.number.toString()
        }
    }
}