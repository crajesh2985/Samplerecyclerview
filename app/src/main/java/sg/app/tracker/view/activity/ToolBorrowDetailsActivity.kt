package sg.app.tracker.view.activity

import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.activity_tool_borrow_details.*
import org.koin.androidx.viewmodel.ext.android.viewModel
import sg.app.tracker.LoanDetails
import sg.app.tracker.R
import sg.app.tracker.adapter.FriendListAdapter
import sg.app.tracker.adapter.ToolBorrowListAdapter
import sg.app.tracker.databinding.ActivityToolBorrowDetailsBinding
import sg.app.tracker.dialog.ReturnInfoDialog
import sg.app.tracker.dialog.UserInfoDialog
import sg.app.tracker.room.entity.FriendDetailsEntity
import sg.app.tracker.room.entity.ToolDetailsEntity
import sg.app.tracker.viewmodel.ToolBorrowDetailsViewModel


class ToolBorrowDetailsActivity : AppCompatActivity() {


     private val toolBorrowDetailsViewModel: ToolBorrowDetailsViewModel by viewModel()


    lateinit var mListRecyclerView: RecyclerView
    lateinit var mAdapter: ToolBorrowListAdapter

    private val observer = Observer<MutableList<FriendDetailsEntity>> {

            mAdapter = ToolBorrowListAdapter(
                it,
                { friendDetailsEntity: FriendDetailsEntity ->
                    toolBorrowItemClicked(
                        friendDetailsEntity
                    )
                })
            mListRecyclerView.adapter = mAdapter

        if(it.size==0) {
            tv_errormsg.visibility = View.VISIBLE
            mListRecyclerView.visibility = View.GONE
        }else{
            tv_errormsg.visibility = View.GONE
            mListRecyclerView.visibility = View.VISIBLE
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        DataBindingUtil.setContentView<ActivityToolBorrowDetailsBinding>(
            this, R.layout.activity_tool_borrow_details
        ).apply {
            this.setLifecycleOwner(this@ToolBorrowDetailsActivity)
        }
        //setContentView(R.layout.activity_home)
        getSupportActionBar()?.hide()

        mListRecyclerView = findViewById(R.id.rv_tool_borrow_list)
        mListRecyclerView.layoutManager = LinearLayoutManager(this)
        toolBorrowDetailsViewModel.getBorrowToolList(intent.getStringExtra("fname")).observe(this, observer)

    }

    private fun toolBorrowItemClicked(friendDetailsEntity : FriendDetailsEntity) {

        val ft = supportFragmentManager?.beginTransaction()
        val newFragment = ReturnInfoDialog.newInstance(friendDetailsEntity.friendBorrowedToolName,
            friendDetailsEntity.friendName,
            { loanDetail : LoanDetails -> dialogReturn(loanDetail) })
        if (ft != null) {
            newFragment.show(ft, "dialog")
        }

    }

    private fun dialogReturn(loanDetail : LoanDetails) {
        toolBorrowDetailsViewModel.dataUpdateToolList(loanDetail).observe(this, observer)
    }


}
