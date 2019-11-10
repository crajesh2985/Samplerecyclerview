package sg.app.tracker.viewholder

import android.util.Log
import androidx.recyclerview.widget.RecyclerView
import sg.app.tracker.adapter.ToolListAdapter
import sg.app.tracker.databinding.ViewToolDetailsBinding
import sg.app.tracker.room.entity.ToolDetailsEntity


class ToolListViewHolder(private val binding: ViewToolDetailsBinding) :
    RecyclerView.ViewHolder(binding.getRoot()) {

    fun bind(
        toolDetailsEntity: ToolDetailsEntity,
        clickListener: (ToolDetailsEntity) -> Unit
    ) {
        binding.tvToolName.text = toolDetailsEntity.toolName
        val totalCount = toolDetailsEntity.toolItemCount
        val availableCount = toolDetailsEntity.toolAvailableCount
        binding.tvToolBorrowCount.text = "$availableCount / $totalCount"

        binding.btnLoaningOut.tag = toolDetailsEntity.toolName

        binding.btnLoaningOut.setOnClickListener {
            Log.d("TAG","it tag ----- >>>>"  + it.tag)
            clickListener(toolDetailsEntity)

        }
        binding.executePendingBindings()
    }
}