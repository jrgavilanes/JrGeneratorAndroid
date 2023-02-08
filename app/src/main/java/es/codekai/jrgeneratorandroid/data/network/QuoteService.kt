package es.codekai.jrgeneratorandroid.data.network

import es.codekai.jrgeneratorandroid.core.RetrofitHelper
import es.codekai.jrgeneratorandroid.data.model.QuoteModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class QuoteService {

    private val retrofit = RetrofitHelper.getRetrofit()

    suspend fun getQuotes(): List<QuoteModel> = withContext(Dispatchers.IO) {
        val response = retrofit.create(QuoteApiClient::class.java).getAllQuotes()
        response.body() ?: emptyList()
    }
}
