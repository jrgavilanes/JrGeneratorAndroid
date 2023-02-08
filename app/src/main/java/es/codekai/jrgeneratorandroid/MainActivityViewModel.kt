package es.codekai.jrgeneratorandroid

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import es.codekai.jrgeneratorandroid.db.Subscriber
import es.codekai.jrgeneratorandroid.db.SubscriberRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MainActivityViewModel(private val repository: SubscriberRepository) : ViewModel() {

    val subscribers = repository.subscribers

    val inputName = MutableLiveData<String>()
    val inputEmail = MutableLiveData<String>()
//    val subscribers = MutableLiveData<List<Subscriber>>()

    fun save() {
        if (!inputEmail.value.isNullOrEmpty() && !inputName.value.isNullOrEmpty()) {
            insert(Subscriber(name = inputName.value!!, email = inputEmail.value!!))
            inputEmail.postValue("")
            inputName.postValue("")
        }
    }

    fun borraTodo() {
        deleteAll()
    }

    private fun insert(subscriber: Subscriber) = viewModelScope.launch(Dispatchers.IO) {
        repository.insert(subscriber)
    }

    private fun update(subscriber: Subscriber) = viewModelScope.launch(Dispatchers.IO) {
        repository.update(subscriber)
    }

    private fun delete(subscriber: Subscriber) = viewModelScope.launch(Dispatchers.IO) {
        repository.delete(subscriber)
    }

    private fun deleteAll() = viewModelScope.launch(Dispatchers.IO) {
        repository.deleteAll()
    }
}
