package es.codekai.jrgeneratorandroid.data.ws.network

import es.codekai.jrgeneratorandroid.data.ws.model.QuoteModel
import retrofit2.Response
import retrofit2.http.GET

interface QuoteApiClient {
    @GET("/.json")
    suspend fun getAllQuotes(): Response<List<QuoteModel>>
}
