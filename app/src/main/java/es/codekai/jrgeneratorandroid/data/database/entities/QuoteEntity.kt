package es.codekai.jrgeneratorandroid.data.database.entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import es.codekai.jrgeneratorandroid.data.ws.model.QuoteModel
import es.codekai.jrgeneratorandroid.domain.model.QuoteItem

@Entity(tableName = "quotes_table")
data class QuoteEntity(
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "id")
    val id: Int = 0,
    @ColumnInfo(name = "quote")
    val quote: String,
    @ColumnInfo(name = "author")
    val author: String
)

fun QuoteModel.toDatabase() = QuoteEntity(id = 0, quote = this.quote, author = this.author)
fun QuoteItem.toDatabase() = QuoteEntity(id = 0, quote = this.quote, author = this.author)
