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
        setUI()
    }

    private fun setUI() {
        binding.apply {
            totalSuma.text = mainActivityViewModel.numero.toString()
            btnSuma5.setOnClickListener {
                mainActivityViewModel.numero += 5
                totalSuma.text = mainActivityViewModel.numero.toString()
            }
        }
    }
}
