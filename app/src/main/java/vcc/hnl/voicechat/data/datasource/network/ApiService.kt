package vcc.hnl.voicechat.data.datasource.network

import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.POST
import retrofit2.http.Path
import vcc.hnl.voicechat.common.model.ChatCompletion
import vcc.hnl.voicechat.common.model.ChatRequest
import vcc.hnl.voicechat.common.model.ModelInfo
import vcc.hnl.voicechat.common.model.Models
import vcc.hnl.voicechat.common.model.TextEmbeddings

interface ApiService {

    @GET("/api/v0/models")
    suspend fun getModels(): Models

    @GET("/api/v0/models/{model}")
    suspend fun getModelInfo(@Path("model") model: String): ModelInfo

    @Headers("Content-Type: application/json")
    @POST("/api/v0/chat/completions")
    suspend fun postChatCompletion(@Body request: ChatRequest): ChatCompletion

    @POST("/api/v0/completions ")
    suspend fun postTextCompletion(): ChatCompletion

    @POST("/api/v0/embeddings")
    suspend fun postTextEmbedding(): TextEmbeddings
}