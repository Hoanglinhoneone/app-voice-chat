package vcc.hnl.voicechat.di

import com.google.gson.Gson
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import vcc.hnl.voicechat.data.datasource.network.ApiService
import vcc.hnl.voicechat.data.repository.chat.ChatRepository
import vcc.hnl.voicechat.data.repository.chat.ChatRepositoryImp
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {
    @Provides
    @Singleton
    fun provideGson(): Gson {
        return Gson()
    }

    @Provides
    @Singleton
    fun bindChatRepository(apiService: ApiService): ChatRepository {
        return ChatRepositoryImp(apiService)
    }

//    @Provides
//    @Singleton
//    fun provideProductRepository(jsonDataSource: JsonDataSource) : ProductRepository {
//        return ProductRepositoryImp(jsonDataSource)
//    }
}