package ru.easycode.zerotoheroandroidtdd

import android.widget.Button
import android.widget.LinearLayout
import android.widget.TextView
import java.io.Serializable

interface RemoveTitleTextView : Serializable {

    fun apply(linearLayout: LinearLayout, textView: TextView, button: Button)


    object Initial : RemoveTitleTextView { // щоб не писати null
        override fun apply(linearLayout: LinearLayout, textView: TextView, button: Button) = Unit
    }

    object Removed : RemoveTitleTextView {
        override fun apply(linearLayout: LinearLayout, textView: TextView, button: Button) {
            linearLayout.removeView(textView)
            button.isEnabled = false
        }
    }

}