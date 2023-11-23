package ru.easycode.zerotoheroandroidtdd

import android.widget.LinearLayout
import android.widget.TextView
import java.io.Serializable

interface RemoveTextViewState : Serializable{

    fun apply(linearLayout: LinearLayout, textView: TextView)

    object Initial : RemoveTextViewState{
        override fun apply(linearLayout: LinearLayout, textView: TextView) = Unit

    }

    object Removed : RemoveTextViewState {
        override fun apply(linearLayout: LinearLayout, textView: TextView) {
            linearLayout.removeView(textView)
        }

    }

}