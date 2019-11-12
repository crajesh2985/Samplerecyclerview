package sg.app.tracker.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import sg.app.tracker.room.entity.ToolDetailsEntity
import sg.app.tracker.viewholder.ToolListViewHolder
import sg.app.tracker.databinding.ViewToolDetailsBinding


class ToolListAdapter(private val list: MutableList<ToolDetailsEntity>, val clickListener: (ToolDetailsEntity) -> Unit)
    : RecyclerView.Adapter<ToolListViewHolder>() {

    override fun getItemCount(): Int = list.size


    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): ToolListViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val itemBinding = ViewToolDetailsBinding.inflate(layoutInflater, parent, false)
        return ToolListViewHolder(itemBinding)
    }

    override fun onBindViewHolder(holder: ToolListViewHolder, position: Int) {
        val toolDetailsEntity:ToolDetailsEntity = list.get(position)


        holder.bind(toolDetailsEntity,clickListener)
    }

}