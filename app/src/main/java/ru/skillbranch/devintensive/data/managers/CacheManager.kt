package ru.skillbranch.devintensive.data.managers

import androidx.lifecycle.MutableLiveData
import ru.skillbranch.devintensive.extensions.mutableLiveData
import ru.skillbranch.devintensive.models.data.Chat
import ru.skillbranch.devintensive.models.data.User

object CacheManager {
    fun generateToha(): List<User> {
        val user = User("0","Toha","Boba")
        return  listOf(user)}

    private fun generateChatToha():Chat{
        return Chat("0","ZELEBOBA", generateToha())
    }

    private val chats = mutableLiveData(listOf(generateChatToha()))
    private val users = mutableLiveData(generateToha())

    fun loadChats(): MutableLiveData<List<Chat>>{
        return chats
    }

    fun findUsersByIds(ids: List<String>) : List<User>{
        return users.value!!.filter { ids.contains(it.id) }
    }

    fun nextChatId():String{
        return "${chats.value!!.size}"
    }

    fun insertChat(chat: Chat){
        val copy = chats.value!!.toMutableList()
        copy.add(chat)
        chats.value = copy
    }

}