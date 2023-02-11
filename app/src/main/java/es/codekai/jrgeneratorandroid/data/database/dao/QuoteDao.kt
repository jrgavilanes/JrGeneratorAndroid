package es.codekai.jrgeneratorandroid.data.database.dao

import androidx.room.* // ktlint-disable no-wildcard-imports
import es.codekai.jrgeneratorandroid.data.database.entities.QuoteEntity

@Dao
interface QuoteDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertQuote(quoteEntity: QuoteEntity)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertQuotes(quotes: List<QuoteEntity>)

    @Update
    suspend fun updateQuote(quoteEntity: QuoteEntity)

    @Delete
    suspend fun deleteQuote(quoteEntity: QuoteEntity)

    @Query("DELETE FROM quotes_table")
    suspend fun deleteAll()

    @Query("SELECT * FROM quotes_table")
    suspend fun getAllQuotes(): List<QuoteEntity>?

    @Query("SELECT * FROM quotes_table WHERE id = :id")
    suspend fun getQuoteById(id: Int): QuoteEntity?
}
