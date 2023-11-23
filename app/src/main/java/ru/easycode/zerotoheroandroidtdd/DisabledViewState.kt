package ru.easycode.zerotoheroandroidtdd

import android.view.View
import java.io.Serializable

interface DisabledViewState : Serializable {
    fun apply(view: View)
    object Initial : DisabledViewState {
        override fun apply(view: View) = Unit

    }

    object Disabled : DisabledViewState {
        override fun apply(view: View) {
            view.isEnabled = false
        }
    }

    object Enabled : DisabledViewState {
        override fun apply(view: View) {
            view.isEnabled = true
        }

    }



}