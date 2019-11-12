package sg.app.tracker.room.entity

import androidx.room.Entity
import androidx.room.PrimaryKey
import androidx.room.ColumnInfo



@Entity(tableName = "tool_details")
data class ToolDetailsEntity(
    @PrimaryKey(autoGenerate = true)
    val id: Int = 0,
    val toolName: String,
    val toolId: Int,
    val toolItemCount: Int,
    val toolAvailableCount: Int,
    val toolBorrowedCount: Int
) {
    companion object {
        fun to(repository: ToolDetailsEntity): ToolDetailsEntity {
            return ToolDetailsEntity(
                toolName = repository.toolName,
                toolId = repository.toolId,
                toolItemCount = repository.toolItemCount,
                toolAvailableCount = repository.toolAvailableCount,
                toolBorrowedCount = repository.toolBorrowedCount
            )
        }
    }
}



