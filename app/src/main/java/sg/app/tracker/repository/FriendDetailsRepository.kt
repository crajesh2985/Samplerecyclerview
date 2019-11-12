package sg.app.tracker.repository

import sg.app.tracker.room.dao.FriendDetailsDAO


class FriendDetailsRepository() {

    suspend fun getFriendList(): MutableList<String> {
        val friendList = mutableListOf("Brian", "Luke", "Letty", "Shaw","Parker")
        return friendList
    }
}
