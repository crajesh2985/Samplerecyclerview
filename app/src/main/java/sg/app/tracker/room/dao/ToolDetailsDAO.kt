package sg.app.tracker.room.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import sg.app.tracker.room.entity.ToolDetailsEntity

@Dao
interface ToolDetailsDAO {

    @Insert
    suspend fun saveAll(entities: List<ToolDetailsEntity>)

    @Query("SELECT count(*) FROM tool_details")
    suspend  fun findToolDetailsCount(): Int

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(toolDetailsEntity: ToolDetailsEntity)

    @Query("SELECT * FROM tool_details")
    suspend  fun getToolDetailList():MutableList<ToolDetailsEntity>

    @Query("SELECT * FROM tool_details WHERE toolName = :tName")
    suspend  fun getToolDetail(tName: String):ToolDetailsEntity


    @Query("UPDATE tool_details SET toolAvailableCount=:tAvailableCount, toolBorrowedCount=:tBorrowedCount  WHERE toolName = :tName")
    suspend fun updateToolDetails(tAvailableCount: Int?, tBorrowedCount: Int?, tName: String)


}