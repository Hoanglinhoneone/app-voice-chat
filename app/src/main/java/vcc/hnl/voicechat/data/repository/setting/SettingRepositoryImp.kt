package vcc.hnl.voicechat.data.repository.setting

import vcc.hnl.voicechat.data.datasource.local.preference.LocalData
import javax.inject.Inject

class SettingRepositoryImp @Inject constructor(
    private val localData: LocalData
) : SettingRepository {
    override suspend fun getDomain(): String {
        return localData.domain
    }

    override suspend fun setDomain(domain: String) {
        localData.domain = domain
    }
}