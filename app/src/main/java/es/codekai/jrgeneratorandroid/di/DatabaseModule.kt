package es.codekai.jrgeneratorandroid.di

import android.content.Context
import androidx.room.Room
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import es.codekai.jrgeneratorandroid.data.database.QuotesDatabase
import es.codekai.jrgeneratorandroid.data.database.dao.QuoteDao
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DatabaseModule {

    private const val QUOTES_DATABASE = "quotes_database"

    @Singleton
    @Provides
    fun provideRoom(@ApplicationContext context: Context): QuotesDatabase {
        return Room.databaseBuilder(
            context,
            QuotesDatabase::class.java,
            QUOTES_DATABASE
        ).build()
    }

    @Singleton
    @Provides
    fun provideQuoteDao(db: QuotesDatabase): QuoteDao {
        return db.getQuoteDao()
    }
}
