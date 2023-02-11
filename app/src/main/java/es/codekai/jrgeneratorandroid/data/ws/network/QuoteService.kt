package es.codekai.jrgeneratorandroid.data.ws.network

import android.util.Log
import es.codekai.jrgeneratorandroid.data.ws.model.QuoteModel
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import retrofit2.Response
import javax.inject.Inject

class QuoteService @Inject constructor(
    private val quoteApiClient: QuoteApiClient,
    private val dispatcher: CoroutineDispatcher = Dispatchers.IO
) {
    suspend fun getQuotes(): List<QuoteModel>? = withContext(dispatcher) {
        try {
            val response: Response<List<QuoteModel>> = quoteApiClient.getAllQuotes()
            response.body() ?: emptyList()
        } catch (e: Exception) {
            Log.d("janrax", "Excepcion: $e")
            null
        }
    }
}
