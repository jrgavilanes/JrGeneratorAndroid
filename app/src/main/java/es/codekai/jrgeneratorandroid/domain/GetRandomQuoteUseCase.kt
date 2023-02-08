package es.codekai.jrgeneratorandroid.domain

import es.codekai.jrgeneratorandroid.data.model.QuoteModel
import es.codekai.jrgeneratorandroid.data.model.QuoteProvider

class GetRandomQuoteUseCase {
    suspend operator fun invoke(): QuoteModel {
        val x = (QuoteProvider.quotes.indices).random()
        return QuoteProvider.quotes[x]
    }
}
