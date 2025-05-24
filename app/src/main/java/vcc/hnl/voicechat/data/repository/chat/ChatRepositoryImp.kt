package vcc.hnl.voicechat.data.repository.chat

import vcc.hnl.voicechat.common.model.ChatCompletion
import vcc.hnl.voicechat.common.model.ChatRequest
import vcc.hnl.voicechat.common.model.ModelInfo
import vcc.hnl.voicechat.common.model.Models
import vcc.hnl.voicechat.data.datasource.network.ApiService
import javax.inject.Inject

class ChatRepositoryImp @Inject constructor(
    private val apiService: ApiService
) : ChatRepository {

    override suspend fun getModels(): Models = apiService.getModels()

    override suspend fun getModelInfo(model: String): ModelInfo = apiService.getModelInfo(model)

    override suspend fun postChatCompletion(request: ChatRequest): ChatCompletion {
        return apiService.postChatCompletion(request)
    }
//
//    override suspend fun postTextCompletion(): ChatCompletion {
//
//    }
//
//    override suspend fun postTextEmbedding(): TextEmbeddings {
//
//    }
}