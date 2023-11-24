package ru.easycode.zerotoheroandroidtdd

import java.io.Serializable

class IncrementHelper(private var number: Int = 1) : Serializable {

    fun doIncrement() {
        number *= 2
    }

    fun getNumber(): Int = number
}