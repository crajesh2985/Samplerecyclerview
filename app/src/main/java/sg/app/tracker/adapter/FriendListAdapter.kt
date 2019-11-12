package sg.app.tracker.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import sg.app.tracker.databinding.ViewFriendDetailsBinding
import sg.app.tracker.viewholder.FriendListViewHolder


class FriendListAdapter(private val list: MutableList<String>, val clickListener: (String) -> Unit)
    : RecyclerView.Adapter<FriendListViewHolder>() {

    override fun getItemCount(): Int = list.size


    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): FriendListViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val itemBinding = ViewFriendDetailsBinding.inflate(layoutInflater, parent, false)
        return FriendListViewHolder(itemBinding)
    }

    override fun onBindViewHolder(holder: FriendListViewHolder, position: Int) {
        val friendName:String = list.get(position)
        holder.bind(friendName,clickListener)
    }

}