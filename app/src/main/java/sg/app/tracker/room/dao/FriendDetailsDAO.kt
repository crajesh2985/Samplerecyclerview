package sg.app.tracker.room.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import sg.app.tracker.room.entity.FriendDetailsEntity

@Dao
interface FriendDetailsDAO {

    @Insert
    suspend fun saveAll(entities: List<FriendDetailsEntity>)

    @Query("SELECT count(*) FROM friends_details")
    suspend  fun findFriendDetailsCount(): Int

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(entity:FriendDetailsEntity)
}