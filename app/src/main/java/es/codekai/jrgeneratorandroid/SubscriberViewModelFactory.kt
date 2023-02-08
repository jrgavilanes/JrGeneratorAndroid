package es.codekai.jrgeneratorandroid

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import es.codekai.jrgeneratorandroid.db.SubscriberRepository

class SubscriberViewModelFactory(private val repository: SubscriberRepository) :
    ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(MainActivityViewModel::class.java)) {
            return MainActivityViewModel(repository) as T
        }
        throw IllegalArgumentException("Unknown ViewModel Class")
    }
}
