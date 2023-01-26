package es.codekai.jrgeneratorandroid

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import es.codekai.jrgeneratorandroid.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private val mainActivityViewModel: MainActivityViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setObservers()
        setListeners()
    }

    private fun setObservers() {
        mainActivityViewModel.num.observe(this) {
            binding.totalSuma.text = it.toString()
        }
    }

    private fun setListeners() {
        binding.apply {
            btnSuma5.setOnClickListener {
                mainActivityViewModel.increaseNum(5)
            }
        }
    }
}
