package es.codekai.jrgeneratorandroid.presentation

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import dagger.hilt.android.AndroidEntryPoint
import es.codekai.jrgeneratorandroid.R
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

        viewModel.error.observe(this) { error ->
            when (error) {
                R.string.no_quotes -> {
                    Toast.makeText(this, getString(R.string.no_quotes), Toast.LENGTH_LONG).show()
                    binding.apply {
                        tvQuote.text = getString(R.string.no_quotes)
                        tvAuthor.text = getString(R.string.check_your_internet_connection)
                    }
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
