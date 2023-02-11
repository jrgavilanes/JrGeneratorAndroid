package es.codekai.jrgeneratorandroid.domain

import es.codekai.jrgeneratorandroid.data.QuoteRepository
import es.codekai.jrgeneratorandroid.domain.model.QuoteItem
import javax.inject.Inject

class GetQuotesUseCase @Inject constructor(
    private val repository: QuoteRepository
) {
    suspend operator fun invoke(): List<QuoteItem> {
        val quotes = repository.getAllQuotesFromApi()
        if (quotes.isNotEmpty()) {
            repository.updateCache(quotes)
            return quotes
        }
        return repository.getAllQuotesFromDatabase()
    }
}
