package es.codekai.jrgeneratorandroid.presentation

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import es.codekai.jrgeneratorandroid.R
import es.codekai.jrgeneratorandroid.domain.GetQuotesUseCase
import es.codekai.jrgeneratorandroid.domain.GetRandomQuoteUseCase
import es.codekai.jrgeneratorandroid.domain.model.QuoteItem
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class QuoteViewModel @Inject constructor(
    private val getQuotesUseCase: GetQuotesUseCase,
    private val getRandomQuoteUseCase: GetRandomQuoteUseCase
) : ViewModel() {

    val quoteModel = MutableLiveData<QuoteItem>()
    val isLoading = MutableLiveData<Boolean>()
    val error = MutableLiveData<Int?>()

    fun onCreate() {
        viewModelScope.launch {
            isLoading.postValue(true)
            val result = getQuotesUseCase()

            if (result.isNotEmpty()) {
                quoteModel.postValue(result[0])
                error.postValue(null)
            } else {
                error.postValue(R.string.no_quotes)
            }

            isLoading.postValue(false)
        }
    }

    fun randomQuote() {
        if (error.value == null) {
            viewModelScope.launch {
                val currentQuote = getRandomQuoteUseCase()
                quoteModel.postValue(currentQuote)
            }
        }
    }
}
