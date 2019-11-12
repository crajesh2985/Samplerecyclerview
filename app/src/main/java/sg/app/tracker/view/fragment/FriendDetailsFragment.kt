package sg.app.tracker.view.fragment

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import org.koin.androidx.viewmodel.ext.android.viewModel
import sg.app.tracker.R
import sg.app.tracker.adapter.FriendListAdapter
import sg.app.tracker.view.activity.ToolBorrowDetailsActivity
import sg.app.tracker.viewmodel.FriendDetailsViewModel


class FriendDetailsFragment : Fragment() {

    lateinit var mListRecyclerView: RecyclerView
    lateinit var mAdapter: FriendListAdapter

    companion object {
        fun newInstance(): FriendDetailsFragment =
            FriendDetailsFragment()
    }


    private val friendDetailsViewModel: FriendDetailsViewModel by viewModel()

    private val observer = Observer<MutableList<String>> {
        mAdapter = FriendListAdapter(it, { friendName : String -> friendNameItemClicked(friendName) })
        mListRecyclerView.adapter = mAdapter
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // inflate the view first, then initialize/bind the RecyclerView
        val view = inflater.inflate(R.layout.fragment_friend_details, container, false)
        mListRecyclerView = view.findViewById(R.id.rv_friend_list)
        mListRecyclerView.layoutManager = LinearLayoutManager(activity)
        friendDetailsViewModel.dataFriendList.observe(this, observer)
        return view
    }


    private fun friendNameItemClicked(fName : String) {

        val intent = Intent(getActivity(), ToolBorrowDetailsActivity::class.java)
        intent.putExtra("fname",fName)
        getActivity()?.startActivity(intent)
    }


}