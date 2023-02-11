package es.codekai.jrgeneratorandroid.data

import es.codekai.jrgeneratorandroid.data.database.dao.QuoteDao
import es.codekai.jrgeneratorandroid.data.database.entities.QuoteEntity
import es.codekai.jrgeneratorandroid.data.database.entities.toDatabase
import es.codekai.jrgeneratorandroid.data.ws.model.QuoteModel
import es.codekai.jrgeneratorandroid.data.ws.network.QuoteService
import es.codekai.jrgeneratorandroid.domain.model.QuoteItem
import es.codekai.jrgeneratorandroid.domain.model.toDomain
import javax.inject.Inject

class QuoteRepository @Inject constructor(
    private val api: QuoteService,
    private val quoteDao: QuoteDao
) {

    suspend fun getAllQuotesFromApi(): List<QuoteItem> {
        val quotes: List<QuoteModel>? = api.getQuotes()
        return quotes?.map { it.toDomain() } ?: emptyList()
    }

    suspend fun updateCache(quotes: List<QuoteItem>) {
        if (quotes.isNotEmpty()) {
            quoteDao.deleteAll()
            quoteDao.insertQuotes(quotes = quotes.map { it.toDatabase() })
        }
    }

    suspend fun getAllQuotesFromDatabase(): List<QuoteItem> {
        val quotes: List<QuoteEntity>? = quoteDao.getAllQuotes()
        return quotes?.map { it.toDomain() } ?: emptyList()
    }
}
