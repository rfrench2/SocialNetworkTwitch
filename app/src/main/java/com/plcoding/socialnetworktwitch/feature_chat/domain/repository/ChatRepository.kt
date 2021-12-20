package com.plcoding.socialnetworktwitch.feature_chat.domain.repository

import com.plcoding.socialnetworktwitch.core.util.Resource
import com.plcoding.socialnetworktwitch.feature_chat.domain.model.Chat
import com.plcoding.socialnetworktwitch.feature_chat.domain.model.Message
import com.tinder.scarlet.WebSocket
import kotlinx.coroutines.flow.Flow

interface ChatRepository {

    fun initialize()

    suspend fun getChatsForUser(): Resource<List<Chat>>

    suspend fun getMessagesForChat(chatId: String, page: Int, pageSize: Int): Resource<List<Message>>

    fun observeChatEvents(): Flow<WebSocket.Event>

    fun observeMessages(): Flow<Message>

    fun sendMessage(toId: String, text: String, chatId: String?)
}