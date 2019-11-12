package sg.app.tracker.viewholder

import androidx.recyclerview.widget.RecyclerView
import sg.app.tracker.R
import sg.app.tracker.databinding.ViewToolBorrowDetailsBinding
import sg.app.tracker.room.entity.FriendDetailsEntity


class ToolBorrowListViewHolder(private val binding: ViewToolBorrowDetailsBinding) :
    RecyclerView.ViewHolder(binding.getRoot()) {

    fun bind(
        friendDetailsEntity: FriendDetailsEntity,
        clickListener: (FriendDetailsEntity) -> Unit
    ) {
        binding.tvToolName.text = friendDetailsEntity.friendBorrowedToolName

        val bCount = friendDetailsEntity.friendBorrowedItemCount
        binding.tvToolBorrowCount.text= "Quantity : x$bCount"

        when (friendDetailsEntity.friendBorrowedToolName) {
            "Air compressor" -> binding.ivToolIcon.setImageResource(R.drawable.ic_air_compressor)
            "Alan key set" -> binding.ivToolIcon.setImageResource(R.drawable.ic_alan_turing)
            "Measuring Tape" -> binding.ivToolIcon.setImageResource(R.drawable.ic_measuring_tape)
            "Hammer" -> binding.ivToolIcon.setImageResource(R.drawable.ic_hammer)
            "Welding glasses" -> binding.ivToolIcon.setImageResource(R.drawable.ic_glasses)
            "Welding machine" -> binding.ivToolIcon.setImageResource(R.drawable.ic_welding)
            "Screwdriver" -> binding.ivToolIcon.setImageResource(R.drawable.ic_screwdriver)
            "Pliers" -> binding.ivToolIcon.setImageResource(R.drawable.ic_pliers)
            "Cutter" -> binding.ivToolIcon.setImageResource(R.drawable.ic_cutter)
            "Wrench" -> binding.ivToolIcon.setImageResource(R.drawable.ic_wrench)

        }

        binding.btnReturn.setOnClickListener {
            clickListener(friendDetailsEntity)
        }
        binding.executePendingBindings()
    }
}