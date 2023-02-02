package es.codekai.jrgeneratorandroid

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import es.codekai.jrgeneratorandroid.databinding.ActivityMainBinding
import es.codekai.jrgeneratorandroid.helpers.Helpers

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setUI()
    }

    private fun setUI() {
        val terremotos = Helpers.terremotosProvider()
        val adapter = TerremotoListAdapter(terremotos, onclickListener = {
            Toast.makeText(this, it.lugar, Toast.LENGTH_SHORT).show()
        })
        binding.apply {
            myRecyclerView.layoutManager = LinearLayoutManager(this@MainActivity)
            myRecyclerView.adapter = adapter
        }
    }
}
