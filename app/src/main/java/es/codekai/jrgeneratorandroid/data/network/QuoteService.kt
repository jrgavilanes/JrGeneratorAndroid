package es.codekai.jrgeneratorandroid.data.network

import es.codekai.jrgeneratorandroid.data.model.QuoteModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import retrofit2.Retrofit
import javax.inject.Inject

class QuoteService @Inject constructor(private val quoteApiClient: QuoteApiClient) {
    suspend fun getQuotes(): List<QuoteModel> = withContext(Dispatchers.IO) {
        val response = quoteApiClient.getAllQuotes()
        response.body() ?: emptyList()
    }
}
