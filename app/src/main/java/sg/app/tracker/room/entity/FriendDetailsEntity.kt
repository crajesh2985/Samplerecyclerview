package sg.app.tracker.room.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey





@Entity(tableName = "friends_details")
data class FriendDetailsEntity(
    @PrimaryKey(autoGenerate = true)
    val id: Int = 0,
    val friendName: String,
    val friendBorrowedToolName: String,
    val friendBorrowedItemCount: Int
) {
    companion object {
        fun to(repository: FriendDetailsEntity): FriendDetailsEntity {
            return FriendDetailsEntity(
                friendName = repository.friendName,
                friendBorrowedToolName = repository.friendBorrowedToolName,
                friendBorrowedItemCount = repository.friendBorrowedItemCount
            )
        }
    }
}