package es.codekai.jrgeneratorandroid

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import es.codekai.jrgeneratorandroid.models.Message
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlin.random.Random

class MainActivityViewModel : ViewModel() {
    private val _messages = MutableLiveData<MutableList<Message>>()
    val messages: LiveData<MutableList<Message>> get() = _messages

    private val _loading = MutableLiveData<Boolean>()
    val loading: LiveData<Boolean> get() = _loading

    init {
        _loading.value = false
    }

    val responses = listOf(
        "Sí",
        "No",
        "Pregunta de nuevo",
        "Es muy probable",
        "No lo creo",
        "No sé 🙁",
        "Tal vez"
    )

    fun sendMessage(message: Message) {
        val aux = _messages.value ?: mutableListOf()
        aux.add(message)

        _messages.value = aux
    }

    fun getBootResponse() {
        viewModelScope.launch {
            _loading.value = true
            delay(Random.nextLong(1000, 3000))
            sendMessage(Message(message = responses.random(), author = "BOT"))
            _loading.value = false
        }
    }
}
