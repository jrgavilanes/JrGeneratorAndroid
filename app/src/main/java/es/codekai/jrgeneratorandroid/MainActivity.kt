package es.codekai.jrgeneratorandroid

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import es.codekai.jrgeneratorandroid.databinding.ActivityMainBinding
import es.codekai.jrgeneratorandroid.helpers.Helpers

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var adapter: MyRecyclerAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setUI()
    }

    private fun setUI() {
        binding.apply {
            val terremotos = Helpers.terremotosProvider()
            if (terremotos.isEmpty()) {
                txtNoData.visibility = View.VISIBLE
            } else {
                txtNoData.visibility = View.GONE
                adapter = MyRecyclerAdapter()
                adapter.submitList(terremotos)
                adapter.onItemClickListener = { terremoto ->
                    Toast.makeText(
                        this@MainActivity,
                        "has pinchado ${terremoto.lugar}",
                        Toast.LENGTH_SHORT
                    ).show()
                }

                myRecycler.layoutManager = LinearLayoutManager(this@MainActivity)
                myRecycler.adapter = adapter
            }
        }
    }
}
