package es.codekai.jrgeneratorandroid

import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import es.codekai.jrgeneratorandroid.databinding.ActivityMainBinding
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private val viewModel: MainActivityViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setObservers()
        setUI()
        getUsers()
    }

    private fun setUI() {
        var contador = 0
        binding.apply {
            btnClickUI.setOnClickListener {
                contador++
                txtButton.text = contador.toString()
            }
        }
    }

    private fun getUsers() {
        binding.progressBar.visibility = View.VISIBLE
        viewModel.getUserData()
    }

    private fun setObservers() {
        viewModel.users.observe(this) { users ->
            binding.apply {
                txtMessage.text = "llegan ${users.size}"
                progressBar.visibility = View.GONE
            }

            // Este lifecycleScope es como el viewModelScope pero para Activities y Fragments
            lifecycleScope.launch(Dispatchers.IO) {
                delay(2000)
                users.forEach { user ->
                    Log.d("janrax", "${user.id} desde ${Thread.currentThread().name}")
                    withContext(Dispatchers.Main) {
                        binding.txtMessage.text = user.name
                        Log.d("janrax", "${user.id} desde ${Thread.currentThread().name}")
                    }
                }
            }
        }

        // Ejemplo con Live Data Builder
        viewModel.users2.observe(this) { users ->
            Log.d("janrax", "Ojo que llega: $users")
        }
    }
}
