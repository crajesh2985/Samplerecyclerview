package sg.app.tracker.viewholder

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import sg.app.tracker.R
import sg.app.tracker.databinding.ViewToolDetailsBinding
import sg.app.tracker.room.entity.ToolDetailsEntity


class ToolListViewHolder(private val binding: ViewToolDetailsBinding) :
    RecyclerView.ViewHolder(binding.getRoot()) {

    fun bind(
        toolDetailsEntity: ToolDetailsEntity,
        clickListener: (ToolDetailsEntity) -> Unit
    ) {

        val totalCount = toolDetailsEntity.toolItemCount
        binding.tvToolName.text = toolDetailsEntity.toolName + "($totalCount)"
        val availableCount = toolDetailsEntity.toolAvailableCount
        val borrowedCount = toolDetailsEntity.toolBorrowedCount

        if( borrowedCount != totalCount){
            binding.btnLoaningOut.visibility = View.VISIBLE
        }else{
            binding.btnLoaningOut.visibility = View.GONE
        }
       // binding.btnLoaningOut.isEnabled = borrowedCount != totalCount

        when (toolDetailsEntity.toolName) {
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


        binding.tvToolBorrowCount.text = "Total No. of Borrow tool $borrowedCount"
        binding.tvToolAvaialbleCount.text = "Total No. of Available tool $availableCount"


        binding.btnLoaningOut.setOnClickListener {
            clickListener(toolDetailsEntity)

        }
        binding.executePendingBindings()
    }
}