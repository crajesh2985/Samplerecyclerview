package sg.app.tracker.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import sg.app.tracker.repository.FriendDetailsRepository


class FriendDetailsViewModel(
    private val dataStoreRepo: FriendDetailsRepository
) : ViewModel() {

    val dataFriendList: LiveData<MutableList<String>> = liveData {
        emit(dataStoreRepo.getFriendList())
    }


}
