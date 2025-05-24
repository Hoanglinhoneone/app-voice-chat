package vcc.hnl.voicechat.common.base

import androidx.lifecycle.ViewModel
import com.google.gson.Gson
import javax.inject.Inject

abstract class BaseViewModel : ViewModel() {
    /* **********************************************************************
     * Variable
     ********************************************************************** */
    @Inject
    lateinit var gson: Gson
}