package es.codekai.jrgeneratorandroid.data

import es.codekai.jrgeneratorandroid.data.model.QuoteModel
import es.codekai.jrgeneratorandroid.data.model.QuoteProvider
import es.codekai.jrgeneratorandroid.data.network.QuoteService
import javax.inject.Inject

class QuoteRepository @Inject constructor(
    private val api: QuoteService,
    private val quoteProvider: QuoteProvider
) {

    suspend fun getAllQuotes(): List<QuoteModel> {
        val response = api.getQuotes()
        quoteProvider.quotes = response
        return response
    }
}
