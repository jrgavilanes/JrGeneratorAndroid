package es.codekai.jrgeneratorandroid

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import es.codekai.jrgeneratorandroid.helpers.BOT
import es.codekai.jrgeneratorandroid.models.Message
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
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

    private suspend fun getResponse(): String {
        delay(Random.nextLong(1000, 3000))
        return responses.random()
    }

    fun getBotResponse() {
        viewModelScope.launch {
            Log.d("janrax", "ejecutando hilo ${Thread.currentThread().name}")
            _loading.value = true

            var response: String
            withContext(Dispatchers.IO) {
                Log.d("janrax2", "ejecutando hilo ${Thread.currentThread().name}")
                response = getResponse()
            }

            sendMessage(Message(message = response, author = BOT))
            _loading.value = false
        }
    }
}
