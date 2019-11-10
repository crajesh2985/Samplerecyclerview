package sg.app.tracker.repository

import sg.app.tracker.room.dao.ToolDetailsDAO
import sg.app.tracker.room.entity.ToolDetailsEntity


class ToolDetailsRepository(
    private val toolDetailsDAO: ToolDetailsDAO
) {

    suspend fun getToolList(): MutableList<ToolDetailsEntity> {
        var toolList: MutableList<ToolDetailsEntity> = toolDetailsDAO.getToolDetailList()
        return toolList

    }
}
