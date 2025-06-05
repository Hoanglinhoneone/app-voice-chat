package vcc.hnl.voicechat.di

import com.google.gson.Gson
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import vcc.hnl.voicechat.common.Constants
import vcc.hnl.voicechat.data.datasource.local.preference.LocalData
import vcc.hnl.voicechat.data.datasource.local.preference.LocalStorage
import vcc.hnl.voicechat.data.datasource.local.preference.PreferenceInfo
import vcc.hnl.voicechat.data.datasource.network.ApiService
import vcc.hnl.voicechat.data.repository.chat.ChatRepository
import vcc.hnl.voicechat.data.repository.chat.ChatRepositoryImp
import vcc.hnl.voicechat.data.repository.setting.SettingRepository
import vcc.hnl.voicechat.data.repository.setting.SettingRepositoryImp
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Singleton
    @Provides
    @PreferenceInfo
    fun providePreferenceName(): String {
        return Constants.PREFERENCE_NAME
    }

    @Provides
    @Singleton
    fun provideLocalRepository(localStorage: LocalData): LocalStorage = localStorage

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

    @Provides
    @Singleton
    fun bindSettingRepository(localData: LocalData): SettingRepository {
        return SettingRepositoryImp(localData)
    }

//    @Provides
//    @Singleton
//    fun provideProductRepository(jsonDataSource: JsonDataSource) : ProductRepository {
//        return ProductRepositoryImp(jsonDataSource)
//    }
}