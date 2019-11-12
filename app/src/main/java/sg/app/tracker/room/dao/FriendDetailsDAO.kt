package sg.app.tracker.room.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import sg.app.tracker.room.entity.FriendDetailsEntity
import sg.app.tracker.room.entity.ToolDetailsEntity

@Dao
interface FriendDetailsDAO {

    @Insert
    suspend fun saveAll(entities: List<FriendDetailsEntity>)

    @Query("SELECT count(*) FROM friends_details")
    suspend  fun findFriendDetailsCount(): Int

    @Query("SELECT * FROM friends_details WHERE friendName = :fName")
    suspend  fun getFriendBorrowToolList(fName:String): MutableList<FriendDetailsEntity>


    @Query("SELECT * FROM friends_details WHERE friendName = :fName AND friendBorrowedToolName =:bToolName")
    suspend  fun getCountOfFriendDetails(fName:String, bToolName:String): FriendDetailsEntity




    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(entity:FriendDetailsEntity)


    @Query("SELECT DISTINCT friendName from friends_details")
    suspend  fun friendNameList():MutableList<String>

    @Query("SELECT count(*) FROM friends_details WHERE friendName = :fName AND friendBorrowedToolName = :fBTName")
    suspend  fun getFriendBorrowedToolCount(fName:String, fBTName:String): Int


    @Query("UPDATE friends_details SET friendBorrowedItemCount=:fBorrowCount WHERE friendName=:fName AND friendBorrowedToolName=:fToolName")
    suspend fun updateFriendDetails(fName: String?, fToolName: String?, fBorrowCount: Int)


    @Query("DELETE FROM friends_details WHERE friendName = :fname AND friendBorrowedToolName = :bName")
    suspend fun deleteBorrowToolDetails(fname:String ,bName:String)

}