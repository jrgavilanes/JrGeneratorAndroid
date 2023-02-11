package es.codekai.jrgeneratorandroid.domain

import es.codekai.jrgeneratorandroid.data.QuoteRepository
import es.codekai.jrgeneratorandroid.domain.model.QuoteItem
import javax.inject.Inject

class GetRandomQuoteUseCase @Inject constructor(
    private val repository: QuoteRepository
) {
    suspend operator fun invoke(): QuoteItem {
        val quotes = repository.getAllQuotesFromDatabase()
        val randomQuote = (quotes.indices).random()
        return quotes[randomQuote]
    }
}
