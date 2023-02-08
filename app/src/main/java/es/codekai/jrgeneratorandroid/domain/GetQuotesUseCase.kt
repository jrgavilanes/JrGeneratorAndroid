package es.codekai.jrgeneratorandroid.domain

import es.codekai.jrgeneratorandroid.data.QuoteRepository
import es.codekai.jrgeneratorandroid.data.model.QuoteModel

class GetQuotesUseCase {

    private val repository = QuoteRepository()

    suspend operator fun invoke(): List<QuoteModel> {
        return repository.getAllQuotes()
    }
}
