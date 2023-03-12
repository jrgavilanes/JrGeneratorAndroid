package es.codekai.jrgeneratorandroid

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity
import es.codekai.jrgeneratorandroid.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private val responseActivityLauncher =
        registerForActivityResult(ActivityResultContracts.StartActivityForResult()) {
            if (it.resultCode == RESULT_OK) {
                val response = it.data?.getStringExtra(RESPONSE_ACTIVITY_NAME).orEmpty()
                Toast.makeText(this, "cachi, ha dicho $response", Toast.LENGTH_SHORT).show()
            } else {
                Toast.makeText(this, "chungui", Toast.LENGTH_SHORT).show()
            }
        }

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
            btnGoToResultActivity.setOnClickListener {
                val intent = Intent(this@MainActivity, ResponseActivity::class.java)
                responseActivityLauncher.launch(intent)
            }
        }
    }
}
