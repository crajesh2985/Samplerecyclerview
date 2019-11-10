package sg.app.tracker.room

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.migration.Migration
import androidx.sqlite.db.SupportSQLiteDatabase
import sg.app.tracker.room.AppDatabase.Companion.DB_VERSION
import sg.app.tracker.room.dao.FriendDetailsDAO
import sg.app.tracker.room.dao.ToolDetailsDAO
import sg.app.tracker.room.entity.FriendDetailsEntity
import sg.app.tracker.room.entity.ToolDetailsEntity

@Database(entities = [FriendDetailsEntity::class, ToolDetailsEntity::class],
    version = DB_VERSION, exportSchema = false)
abstract class AppDatabase : RoomDatabase() {
    abstract fun getFriendDetailsDAO(): FriendDetailsDAO

    abstract fun getToolDetailsDAO(): ToolDetailsDAO

    companion object {
        const val DB_VERSION = 1
        private const val DB_NAME = "tool_tracker.db"
        @Volatile
        private var INSTANCE: AppDatabase? = null

        fun getInstance(context: Context): AppDatabase =
            INSTANCE ?: synchronized(this) {
                INSTANCE ?: build(context).also { INSTANCE = it }
            }

        private fun build(context: Context) =
            Room.databaseBuilder(context.applicationContext, AppDatabase::class.java, DB_NAME)
                .addMigrations(MIGRATION_1_TO_2)
                .build()

        private val MIGRATION_1_TO_2 = object : Migration(1, 2) {
            override fun migrate(database: SupportSQLiteDatabase) {

            }
        }
    }
}