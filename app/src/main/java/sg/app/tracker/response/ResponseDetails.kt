package sg.app.tracker.response

import java.util.*

data class ToolDetailsResponse(

    var toolName: String,
    var toolId: Int,
    var toolItemCount: Int,
    var toolAvailableCount: Int,
    var toolBorrowedCount: Int
)


data class FriendDetailsResponse(

    val friendName: String,
    val friendBorrowedToolName: String,
    val friendBorrowedItemCount: Int
)
