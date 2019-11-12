package sg.app.tracker.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import sg.app.tracker.databinding.ViewToolBorrowDetailsBinding
import sg.app.tracker.room.entity.FriendDetailsEntity
import sg.app.tracker.viewholder.ToolBorrowListViewHolder


class ToolBorrowListAdapter(private val list: MutableList<FriendDetailsEntity>,
                            val clickListener: (FriendDetailsEntity) -> Unit)
    : RecyclerView.Adapter<ToolBorrowListViewHolder>() {

    override fun getItemCount(): Int = list.size


    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): ToolBorrowListViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val itemBinding = ViewToolBorrowDetailsBinding.inflate(layoutInflater, parent, false)
        return ToolBorrowListViewHolder(itemBinding)
    }

    override fun onBindViewHolder(holder: ToolBorrowListViewHolder, position: Int) {
        val friendDetailsEntity:FriendDetailsEntity = list.get(position)
        holder.bind(friendDetailsEntity,clickListener)
    }

}