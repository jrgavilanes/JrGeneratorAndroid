package es.codekai.jrgeneratorandroid

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import es.codekai.jrgeneratorandroid.model.QuoteModel
import es.codekai.jrgeneratorandroid.model.QuoteProvider

class QuoteViewModel : ViewModel() {

    val quoteModel = MutableLiveData<QuoteModel>()

    init {
        randomQuote()
    }

    fun randomQuote() {
        val currentQuote = QuoteProvider.random()
        quoteModel.postValue(currentQuote)
    }
}
