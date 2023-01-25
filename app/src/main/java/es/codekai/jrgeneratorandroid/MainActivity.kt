package es.codekai.jrgeneratorandroid

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import es.codekai.jrgeneratorandroid.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        showUI()
    }

    private fun showUI() {
        binding.apply {
            button.setOnClickListener {
                if (progressBar.visibility == View.GONE && button.text == getString(R.string.show)) {
                    progressBar.visibility = View.VISIBLE
                    button.text = getString(R.string.hide)
                } else {
                    progressBar.visibility = View.GONE
                    button.text = getString(R.string.show)
                }
            }
        }
    }
}
