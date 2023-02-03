package es.codekai.jrgeneratorandroid

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MainActivityViewModel : ViewModel() {
    private val _messages = MutableLiveData<MutableList<Message>>()
    val messages: LiveData<MutableList<Message>> get() = _messages

    init {
        _messages.value = mutableListOf()
    }

    fun sendMessage(message: Message) {
        val aux = _messages.value
        aux?.add(message)

        _messages.value = aux
        Log.d("janrax1", _messages.value.toString())
    }
}
