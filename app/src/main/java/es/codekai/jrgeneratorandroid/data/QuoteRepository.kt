package es.codekai.jrgeneratorandroid.data

import es.codekai.jrgeneratorandroid.data.model.QuoteModel
import es.codekai.jrgeneratorandroid.data.model.QuoteProvider
import es.codekai.jrgeneratorandroid.data.network.QuoteService

class QuoteRepository {

    private val api = QuoteService()

    suspend fun getAllQuotes(): List<QuoteModel> {
        val response = api.getQuotes()
        QuoteProvider.quotes = response
        return response
    }
}
