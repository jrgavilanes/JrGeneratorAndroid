package es.codekai.jrgeneratorandroid

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MainActivityViewModel : ViewModel() {
    private val _messages = MutableLiveData<MutableList<String>>()
    val messages: LiveData<MutableList<String>> get() = _messages

    init {
        _messages.value = mutableListOf()
    }

    fun sendMessage(message: String) {
        _messages.value?.add(message)
    }
}
