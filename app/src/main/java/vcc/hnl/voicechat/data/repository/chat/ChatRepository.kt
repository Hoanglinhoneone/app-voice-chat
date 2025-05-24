package vcc.hnl.voicechat.data.repository.chat

import vcc.hnl.voicechat.common.model.ChatCompletion
import vcc.hnl.voicechat.common.model.ChatRequest
import vcc.hnl.voicechat.common.model.ModelInfo
import vcc.hnl.voicechat.common.model.Models


interface ChatRepository {

    suspend fun getModels(): Models

    suspend fun getModelInfo(model: String): ModelInfo

    suspend fun postChatCompletion(request: ChatRequest): ChatCompletion
//
//    suspend fun postTextCompletion(): ChatCompletion
//
//    suspend fun postTextEmbedding(): TextEmbeddings
}
