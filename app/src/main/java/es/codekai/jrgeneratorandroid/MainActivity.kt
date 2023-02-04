package es.codekai.jrgeneratorandroid

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import es.codekai.jrgeneratorandroid.databinding.ActivityMainBinding
import es.codekai.jrgeneratorandroid.helpers.ME
import es.codekai.jrgeneratorandroid.helpers.hideKeyboard
import es.codekai.jrgeneratorandroid.models.Message

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private val viewModel: MainActivityViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setObservers()
        setUI()
    }

    private fun setUI() {
        binding.apply {
            btnSend.setOnClickListener {
                if (!binding.edMessage.text.isNullOrEmpty()) {
                    viewModel.sendMessage(
                        Message(
                            message = binding.edMessage.text.toString(),
                            author = ME
                        )
                    )
                    binding.edMessage.setText("")
                    binding.root.hideKeyboard()
                    viewModel.getBootResponse()
                } else {
                    Toast.makeText(this@MainActivity, getString(R.string.ask_your_question), Toast.LENGTH_SHORT)
                        .show()
                }
            }
        }
        refreshRecyclerView(mutableListOf())
    }

    private fun refreshRecyclerView(messages: MutableList<Message>) {
        binding.apply {
            if (messages.size == 0) {
                txtEmptyQuestions.visibility = View.VISIBLE
                recyclerView.visibility = View.GONE
            } else {
                val adapter = MessageListAdapter(
                    messages,
                    onclickListener = { message ->
                        Toast.makeText(this@MainActivity, message.message, Toast.LENGTH_SHORT)
                            .show()
                    }
                )

                recyclerView.visibility = View.VISIBLE
                txtEmptyQuestions.visibility = View.GONE
                recyclerView.layoutManager = LinearLayoutManager(this@MainActivity)
                recyclerView.adapter = adapter
                recyclerView.scrollToPosition(messages.size - 1)
            }
        }
    }

    private fun setObservers() {
        viewModel.messages.observe(this) {
            refreshRecyclerView(it)
        }

        viewModel.loading.observe(this) { isLoading ->
            if (isLoading) {
                binding.progressBar.visibility = View.VISIBLE
            } else {
                binding.progressBar.visibility = View.GONE
            }
        }
    }
}
