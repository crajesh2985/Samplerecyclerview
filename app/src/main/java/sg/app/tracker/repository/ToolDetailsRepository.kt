package sg.app.tracker.repository

import sg.app.tracker.LoanDetails
import sg.app.tracker.room.dao.FriendDetailsDAO
import sg.app.tracker.room.dao.ToolDetailsDAO
import sg.app.tracker.room.entity.FriendDetailsEntity
import sg.app.tracker.room.entity.ToolDetailsEntity


class ToolDetailsRepository(
    private val toolDetailsDAO: ToolDetailsDAO,
    private val friendDetailsDAO: FriendDetailsDAO
) {

    suspend fun getToolList(): MutableList<ToolDetailsEntity> {
        var toolList: MutableList<ToolDetailsEntity> = toolDetailsDAO.getToolDetailList()
        return toolList

    }

    suspend fun updateToolList(loanDetails: LoanDetails): MutableList<ToolDetailsEntity>  {
        var toolDetailsEntity :ToolDetailsEntity =  toolDetailsDAO.getToolDetail(loanDetails.toolName)
        val tACount = toolDetailsEntity.toolItemCount - toolDetailsEntity.toolBorrowedCount - 1
        val tBCount = toolDetailsEntity.toolBorrowedCount + 1
        toolDetailsDAO.updateToolDetails(tACount, tBCount, loanDetails.toolName)

        val borrowCount = friendDetailsDAO.getFriendBorrowedToolCount(loanDetails.friendName, loanDetails.toolName)
        if(borrowCount>0){

            val bCount = borrowCount + 1
            friendDetailsDAO.updateFriendDetails(loanDetails.friendName, loanDetails.toolName, bCount)

        }else{
            var friendDetailsEntity = FriendDetailsEntity(
                friendName = loanDetails.friendName,
                friendBorrowedToolName = loanDetails.toolName,
                friendBorrowedItemCount = 1
            )
            friendDetailsDAO.insert(friendDetailsEntity)
        }


        var toolList: MutableList<ToolDetailsEntity> = toolDetailsDAO.getToolDetailList()
        return toolList
    }
}
