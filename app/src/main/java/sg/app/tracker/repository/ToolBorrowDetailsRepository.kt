package sg.app.tracker.repository

import sg.app.tracker.LoanDetails
import sg.app.tracker.room.dao.FriendDetailsDAO
import sg.app.tracker.room.dao.ToolDetailsDAO
import sg.app.tracker.room.entity.FriendDetailsEntity
import sg.app.tracker.room.entity.ToolDetailsEntity


class ToolBorrowDetailsRepository(
    private val toolDetailsDAO: ToolDetailsDAO,
    private val friendDetailsDAO: FriendDetailsDAO) {

    suspend fun getBorrowToolList(fName:String): MutableList<FriendDetailsEntity> {
        var toolBorrowList: MutableList<FriendDetailsEntity> = friendDetailsDAO.getFriendBorrowToolList(fName)
        return toolBorrowList
    }


    suspend fun updateReturnToolDetails(loanDetail : LoanDetails): MutableList<FriendDetailsEntity> {

        val friendDetailsEntity = friendDetailsDAO.getCountOfFriendDetails(loanDetail.friendName, loanDetail.toolName)
        if(friendDetailsEntity.friendBorrowedItemCount == 1){
            friendDetailsDAO.deleteBorrowToolDetails(loanDetail.friendName, loanDetail.toolName)
        }else{
            val countDetail = friendDetailsEntity.friendBorrowedItemCount - 1

            friendDetailsDAO.updateFriendDetails(loanDetail.friendName, loanDetail.toolName, countDetail)
        }

        var toolDetailsEntity :ToolDetailsEntity =  toolDetailsDAO.getToolDetail(loanDetail.toolName)

        val tACount = toolDetailsEntity.toolAvailableCount + 1
        val tBCount = toolDetailsEntity.toolBorrowedCount - 1
        toolDetailsDAO.updateToolDetails(tACount, tBCount, loanDetail.toolName)

        var toolBorrowList: MutableList<FriendDetailsEntity> = friendDetailsDAO.getFriendBorrowToolList(loanDetail.friendName)
        return toolBorrowList
    }
}
