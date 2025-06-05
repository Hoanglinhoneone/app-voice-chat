package vcc.hnl.voicechat.data.datasource.local.preference

import kotlin.reflect.KClass

interface LocalStorage {

    fun putString(key: String, value: String?)
    fun getString(key: String): String?
    fun remove(key: String)

    var authorization: String?

    fun <T : Any> putData(key: String, t: T?)

    fun <T : Any> getData(key: String): T?

    fun <T : Any> getData(key: String, clazz: KClass<T>): T?

    var isSignedIn: Boolean
    var authToken: String
    var domain: String
    var langCode: String

}