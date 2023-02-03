package es.codekai.jrgeneratorandroid

import android.os.Bundle
import android.util.Log
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import es.codekai.jrgeneratorandroid.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private val viewModel: MainActivityViewModel by viewModels()
    private lateinit var messages: MutableList<Message>
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setObservers()
        setUI()
    }

    private fun setUI() {
        messages = mutableListOf(
            Message("hola", "yo"),
            Message("k ase?", "robot")
        )
        val adapter = MessageListAdapter(messages, onclickListener = { })
        binding.apply {
            recyclerView.layoutManager = LinearLayoutManager(this@MainActivity)
            recyclerView.adapter = adapter
            btnSend.setOnClickListener {
                if (!binding.edMessage.text.isNullOrEmpty()) {
                    viewModel.sendMessage(
                        Message(
                            message = binding.edMessage.text.toString(),
                            author = "yo"
                        )
                    )
                    binding.edMessage.setText("")
                }
            }
        }
    }

    private fun setObservers() {
        viewModel.messages.observe(this) {
            messages = it
            Log.d("janrax", messages.toString())
        }
    }
}
