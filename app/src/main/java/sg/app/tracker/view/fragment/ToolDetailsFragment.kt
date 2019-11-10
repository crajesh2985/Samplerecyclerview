package sg.app.tracker.view.fragment

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
import sg.app.tracker.adapter.ToolListAdapter
import sg.app.tracker.room.entity.ToolDetailsEntity
import sg.app.tracker.viewmodel.ToolDetailsViewModel


class ToolDetailsFragment : Fragment() {



    lateinit var mListRecyclerView: RecyclerView
    lateinit var mAdapter: ToolListAdapter

    companion object {
        fun newInstance(): ToolDetailsFragment =
            ToolDetailsFragment()
    }


    private val toolDetailsViewModel: ToolDetailsViewModel by viewModel()

    private val observer = Observer<MutableList<ToolDetailsEntity>> {

        mAdapter = ToolListAdapter(it, { partItem : ToolDetailsEntity -> partItemClicked(partItem) })
        mListRecyclerView.adapter = mAdapter



    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // inflate the view first, then initialize/bind the RecyclerView
        val view = inflater.inflate(R.layout.fragment_tool_details, container, false)
        mListRecyclerView = view.findViewById(R.id.rv_tool_list)
        mListRecyclerView.layoutManager = LinearLayoutManager(activity)
        toolDetailsViewModel.dataToolList.observe(this, observer)
        return view
    }


    private fun partItemClicked(toolDetailsEntity : ToolDetailsEntity) {
        Log.d("TAG","partItemClicked ----- >>>>>> " +toolDetailsEntity.toolName)



    }


}