package es.codekai.jrgeneratorandroid.data.database

import androidx.room.Database
import androidx.room.RoomDatabase
import es.codekai.jrgeneratorandroid.data.database.dao.QuoteDao
import es.codekai.jrgeneratorandroid.data.database.entities.QuoteEntity

@Database(entities = [QuoteEntity::class], version = 1)
abstract class QuotesDatabase : RoomDatabase() {

    abstract fun getQuoteDao(): QuoteDao
}
