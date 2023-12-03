package ru.easycode.zerotoheroandroidtdd

import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.SupervisorJob
import kotlinx.coroutines.launch

class MainViewModel(
    private val liveDataWrapper: LiveDataWrapper,
    private val repository: Repository
) {

    //додавання скоупу без додавання сторонніх бібліотек
    private val viewModelScope = CoroutineScope(SupervisorJob() + Dispatchers.Main.immediate)

    fun liveData() = liveDataWrapper.getLiveData()

    fun load() {
        liveDataWrapper.update(UiState.ShowProgress) // просто шоупрогрес, без шоу дата, бо дату ми ще не підтянули
        viewModelScope.launch {
            repository.load() //суспенд функція в корутині
            liveDataWrapper.update(UiState.ShowData) //після лоуду з репозиторію можемо оновлювати статус до шоудата
        }

    }

}