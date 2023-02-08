package es.codekai.jrgeneratorandroid

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import es.codekai.jrgeneratorandroid.databinding.ActivityMainBinding
import es.codekai.jrgeneratorandroid.db.SubscriberDatabase
import es.codekai.jrgeneratorandroid.db.SubscriberRepository

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var viewModel: MainActivityViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Fabrica el viewModel pasándole el dao en su constructor ( flipassss )
        val dao = SubscriberDatabase.getInstance(application).subscriberDAO
        val repository = SubscriberRepository(dao)
        val factory = SubscriberViewModelFactory(repository)
        viewModel = ViewModelProvider(this, factory)[MainActivityViewModel::class.java]

        binding.viewModel = viewModel
        binding.lifecycleOwner = this

        setObservers()
    }

    private fun setObservers() {
        viewModel.subscribers?.observe(this) {
            Log.d("janrax", it.toString())
        }
    }
}
