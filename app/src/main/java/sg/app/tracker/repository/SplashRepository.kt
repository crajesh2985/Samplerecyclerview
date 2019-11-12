package sg.app.tracker.repository

import android.content.Context
import com.google.gson.Gson
import sg.app.tracker.room.dao.FriendDetailsDAO
import sg.app.tracker.room.dao.ToolDetailsDAO
import sg.app.tracker.room.entity.ToolDetailsEntity
import java.io.InputStream


class SplashRepository(private val context: Context,
    private val friendDetailsDAO: FriendDetailsDAO,
    private val toolDetailsDAO: ToolDetailsDAO
) {

    suspend fun getWeather(): Boolean {
        val countDetail = toolDetailsDAO.findToolDetailsCount()
        if(countDetail>0){
            return true
        }else{
            var gson = Gson()
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
