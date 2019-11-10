package sg.app.tracker.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import sg.app.tracker.repository.SplashRepository


class SplashViewModel(
    private val dataStoreRepo: SplashRepository
) : ViewModel() {

    val dataStoreList: LiveData<Boolean> = liveData {
        emit(dataStoreRepo.getWeather())
    }
}
