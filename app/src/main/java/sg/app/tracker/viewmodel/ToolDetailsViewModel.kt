package sg.app.tracker.viewmodel

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import sg.app.tracker.R
import sg.app.tracker.repository.ToolDetailsRepository
import sg.app.tracker.room.entity.ToolDetailsEntity


class ToolDetailsViewModel(
    private val dataStoreRepo: ToolDetailsRepository
) : ViewModel() {

    val dataToolList: LiveData<MutableList<ToolDetailsEntity>> = liveData {
        emit(dataStoreRepo.getToolList())
    }


}
