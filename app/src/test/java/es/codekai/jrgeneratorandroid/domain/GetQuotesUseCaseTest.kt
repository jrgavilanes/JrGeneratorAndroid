package es.codekai.jrgeneratorandroid.domain

import es.codekai.jrgeneratorandroid.data.QuoteRepository
import es.codekai.jrgeneratorandroid.domain.model.QuoteItem
import io.mockk.MockKAnnotations
import io.mockk.coEvery
import io.mockk.coVerify
import io.mockk.impl.annotations.RelaxedMockK
import kotlinx.coroutines.runBlocking
import org.junit.Before
import org.junit.Test

class GetQuotesUseCaseTest {

    @RelaxedMockK
    private lateinit var quoteRepository: QuoteRepository

    private lateinit var getQuotesUseCase: GetQuotesUseCase

    @Before
    fun onBefore() {
        MockKAnnotations.init(this)
        getQuotesUseCase = GetQuotesUseCase(quoteRepository)
    }

    @Test
    fun `when get all quotes from api, if not empty response given then update room cache`() =
        runBlocking {
            // Given
            val quotes = listOf(
                QuoteItem("a", "b"),
                QuoteItem("c", "d")
            )
            coEvery { quoteRepository.getAllQuotesFromApi() } returns quotes
            // When
            val result = getQuotesUseCase()
            // Then
            coVerify(exactly = 1) { quoteRepository.getAllQuotesFromApi() }
            coVerify(exactly = 1) { quoteRepository.updateCache(any()) }
            coVerify(exactly = 0) { quoteRepository.getAllQuotesFromDatabase() }
            assert(result == quotes)
        }

    @Test
    fun `when get all quotes from api, if empty response given then get quotes from room cache`() =
        runBlocking {
            // Given
            coEvery { quoteRepository.getAllQuotesFromApi() } returns emptyList()
            // When
            getQuotesUseCase()
            // Then
            coVerify(exactly = 1) { quoteRepository.getAllQuotesFromDatabase() }
        }
}
