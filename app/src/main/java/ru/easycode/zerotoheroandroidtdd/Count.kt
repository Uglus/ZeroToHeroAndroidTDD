package ru.easycode.zerotoheroandroidtdd

import kotlin.Exception

interface Count {
    fun increment(number: String): UiState
    class Base(private val step: Int, private val max: Int) : Count {

        init {
            if (step > max) {
                throw Exception("max should be more than step")
            }
            if (max < 1) {
                throw Exception("max should be positive, but was $max")
            }
            if (step < 1) {
                throw Exception("step should be positive, but was $step")
            }
        }

        override fun increment(number: String): UiState {
            val answer = number.toInt() + step

            return if (answer + step > max)
                UiState.Max(text = answer.toString())
            else
                UiState.Base(text = answer.toString())
        }
    }
}

