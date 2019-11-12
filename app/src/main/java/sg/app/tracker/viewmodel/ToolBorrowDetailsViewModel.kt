package sg.app.tracker.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import sg.app.tracker.LoanDetails
import sg.app.tracker.repository.ToolBorrowDetailsRepository
import sg.app.tracker.room.entity.FriendDetailsEntity


class ToolBorrowDetailsViewModel(
    private val dataStoreRepo: ToolBorrowDetailsRepository
) : ViewModel() {


    fun getBorrowToolList(fname: String): LiveData<MutableList<FriendDetailsEntity>> = liveData {
        emit(dataStoreRepo.getBorrowToolList(fname))
    }

    fun dataUpdateToolList(loanDetail : LoanDetails): LiveData<MutableList<FriendDetailsEntity>> = liveData {
        emit(dataStoreRepo.updateReturnToolDetails(loanDetail))
    }
}
