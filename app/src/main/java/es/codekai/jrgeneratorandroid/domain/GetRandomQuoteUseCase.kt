package es.codekai.jrgeneratorandroid.domain

import es.codekai.jrgeneratorandroid.data.model.QuoteModel
import es.codekai.jrgeneratorandroid.data.model.QuoteProvider
import javax.inject.Inject

class GetRandomQuoteUseCase @Inject constructor(private val quoteProvider: QuoteProvider) {
    suspend operator fun invoke(): QuoteModel {
        val quotes = quoteProvider.quotes
        val randomQuote = (quotes.indices).random()
        return quotes[randomQuote]
    }
}
