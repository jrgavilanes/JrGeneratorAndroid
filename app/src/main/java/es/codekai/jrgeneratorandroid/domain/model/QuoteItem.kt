package es.codekai.jrgeneratorandroid.domain.model

import es.codekai.jrgeneratorandroid.data.database.entities.QuoteEntity
import es.codekai.jrgeneratorandroid.data.ws.model.QuoteModel

data class QuoteItem(
    val quote: String,
    val author: String
)

fun QuoteModel.toDomain() = QuoteItem(quote = this.quote, author = this.author)
fun QuoteEntity.toDomain() = QuoteItem(quote = this.quote, author = this.author)
