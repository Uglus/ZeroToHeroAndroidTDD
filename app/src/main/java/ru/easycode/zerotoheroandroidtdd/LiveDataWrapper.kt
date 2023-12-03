package ru.easycode.zerotoheroandroidtdd

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData

interface LiveDataWrapper {

    fun update(value: UiState)

    fun getLiveData(): LiveData<UiState>

    class Base(
        //приватна інкапсульована мутабельна лівдата, все по стандартам гугла,
        // з умовою що лівдата в окоремому класі, а не в вюмоделі
        private val mutableLiveData: MutableLiveData<UiState> = MutableLiveData()
    ) : LiveDataWrapper {

        override fun update(value: UiState) {
            mutableLiveData.value = value // setValue
        }

        override fun getLiveData(): LiveData<UiState> =
            mutableLiveData // повертаємо немутабельну лівдату

    }


}