package es.codekai.jrgeneratorandroid

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import es.codekai.jrgeneratorandroid.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setUI()
    }

    private fun setUI() {
        binding.apply {
            btnGoToSecond.setOnClickListener {
                val intent = Intent(
                    this@MainActivity,
                    SecondActivity::class.java
                ).apply {
                    putExtra(EXTRA_MESSAGE, edName.text.toString())
                }
                startActivity(intent)
            }
        }
    }
}
