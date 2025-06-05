package vcc.hnl.voicechat.data.repository.setting

interface SettingRepository {
    suspend fun getDomain(): String
    suspend fun setDomain(domain: String)
}