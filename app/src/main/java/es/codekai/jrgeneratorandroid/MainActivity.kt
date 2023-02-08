package es.codekai.jrgeneratorandroid

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import es.codekai.jrgeneratorandroid.databinding.ActivityMainBinding

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
    }

    private fun setUI() {
        binding.apply {
            viewContainer.setOnClickListener {
                viewModel.randomQuote()
            }
        }
    }
}
