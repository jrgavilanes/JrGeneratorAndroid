package es.codekai.jrgeneratorandroid

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import es.codekai.jrgeneratorandroid.databinding.ActivitySecondBinding

const val EXTRA_MESSAGE = "com.example.myfirstapp.MESSAGE"

class SecondActivity : AppCompatActivity() {
    private lateinit var binding: ActivitySecondBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySecondBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setUI()
    }

    private fun setUI() {
        val name = intent.getStringExtra(EXTRA_MESSAGE).orEmpty()
        binding.apply {
            txtTitulo.text = "Hola $name"
        }
    }
}
