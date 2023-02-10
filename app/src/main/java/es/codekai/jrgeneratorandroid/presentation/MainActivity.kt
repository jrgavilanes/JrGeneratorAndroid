package es.codekai.jrgeneratorandroid.presentation

import android.os.Bundle
import android.view.View
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import dagger.hilt.EntryPoint
import dagger.hilt.android.AndroidEntryPoint
import es.codekai.jrgeneratorandroid.databinding.ActivityMainBinding

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private val viewModel: QuoteViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setUI()
        setObservers()
    }

    private fun setObservers() {
        viewModel.quoteModel.observe(this) { quote ->
            binding.apply {
                tvAuthor.text = quote.author
                tvQuote.text = quote.quote
            }
        }

        viewModel.isLoading.observe(this) { isLoading ->
            binding.apply {
                if (isLoading) {
                    progress.visibility = View.VISIBLE
                } else {
                    progress.visibility = View.GONE
                }
            }
        }
    }

    private fun setUI() {
        binding.apply {
            viewContainer.setOnClickListener {
                viewModel.randomQuote()
            }
        }
        viewModel.onCreate()
    }
}
