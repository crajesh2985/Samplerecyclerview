package sg.app.tracker.viewholder

import androidx.recyclerview.widget.RecyclerView
import sg.app.tracker.databinding.ViewFriendDetailsBinding


class FriendListViewHolder(private val binding: ViewFriendDetailsBinding) :
    RecyclerView.ViewHolder(binding.getRoot()) {

    fun bind(
        friendName: String,
        clickListener: (String) -> Unit
    ) {
        binding.tvFriendName.text = friendName

        binding.llFriendName.setOnClickListener {
            clickListener(friendName)
        }
        binding.executePendingBindings()
    }
}