package es.codekai.jrgeneratorandroid.presentation

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import es.codekai.jrgeneratorandroid.domain.GetQuotesUseCase
import es.codekai.jrgeneratorandroid.domain.GetRandomQuoteUseCase
import es.codekai.jrgeneratorandroid.domain.model.QuoteItem
import io.mockk.MockKAnnotations
import io.mockk.coEvery
import io.mockk.impl.annotations.RelaxedMockK
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.resetMain
import kotlinx.coroutines.test.runTest
import kotlinx.coroutines.test.setMain
import org.junit.After
import org.junit.Before
import org.junit.Rule
import org.junit.Test

@ExperimentalCoroutinesApi
class QuoteViewModelTest {

    @RelaxedMockK
    private lateinit var getQuotesUseCase: GetQuotesUseCase

    @RelaxedMockK
    private lateinit var getRandomQuoteUseCase: GetRandomQuoteUseCase

    private lateinit var quoteViewModel: QuoteViewModel

    @get:Rule
    var rule: InstantTaskExecutorRule = InstantTaskExecutorRule()

    @Before
    fun onBefore() {
        MockKAnnotations.init(this)
        quoteViewModel = QuoteViewModel(getQuotesUseCase, getRandomQuoteUseCase)
        Dispatchers.setMain(Dispatchers.Unconfined)
    }

    @After
    fun onAfter() {
        Dispatchers.resetMain()
    }

    @Test
    fun firstTest() = runTest {
        // Given
        val quotes = listOf(QuoteItem("a", "b"), QuoteItem("c", "d"))
        coEvery { getQuotesUseCase() } returns quotes
        // When
        quoteViewModel.onCreate()
        // Then
        assert(quoteViewModel.quoteModel.value == quotes.first())
    }
}
