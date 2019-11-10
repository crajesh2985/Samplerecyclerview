package sg.app.tracker.repository

import android.content.Context
import android.util.Log
import com.google.gson.Gson
import sg.app.tracker.response.FriendDetailsResponse
import sg.app.tracker.room.dao.FriendDetailsDAO
import sg.app.tracker.room.dao.ToolDetailsDAO
import sg.app.tracker.room.entity.FriendDetailsEntity
import sg.app.tracker.room.entity.ToolDetailsEntity
import java.io.InputStream


class SplashRepository(private val context: Context,
    private val friendDetailsDAO: FriendDetailsDAO,
    private val toolDetailsDAO: ToolDetailsDAO
) {

    suspend fun getWeather(): Boolean {
        val countDetail = friendDetailsDAO.findFriendDetailsCount()
        if(countDetail>0){
            return true
        }else{
            var gson = Gson()

            var friendListStr = readJSONFromAsset(context,"friend_list.json")
            var friendList:List<FriendDetailsEntity>  =
                gson.fromJson(friendListStr, Array<FriendDetailsEntity>::class.java).toList()
            friendDetailsDAO.saveAll(friendList)

            var toolDetailStr = readJSONFromAsset(context,"tool_details.json")
            var toolList:List<ToolDetailsEntity>  =
                gson.fromJson(toolDetailStr, Array<ToolDetailsEntity>::class.java).toList()
            toolDetailsDAO.saveAll(toolList)

            return false
        }
    }


    fun readJSONFromAsset(context:Context, fileName:String): String? {
        var json: String? = null
        try {
            val  inputStream: InputStream = context.assets.open(fileName)
            json = inputStream.bufferedReader().use{it.readText()}
        } catch (ex: Exception) {
            ex.printStackTrace()
            return null
        }
        return json
    }
}
