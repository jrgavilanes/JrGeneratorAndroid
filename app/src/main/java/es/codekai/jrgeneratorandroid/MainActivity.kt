package es.codekai.jrgeneratorandroid

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
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
            val adapter = MyRecyclerAdapter()
            myRecycler.layoutManager = LinearLayoutManager(this@MainActivity)
            myRecycler.adapter = adapter
            adapter.submitList(terremotosProvider())
        }
    }

    private fun terremotosProvider(): List<Terremoto> {
        val terremotos = mutableListOf<Terremoto>()
        terremotos.add(Terremoto("1", "Valencia", "5.4", 1234L, -380.2, 6.21))
        terremotos.add(Terremoto("2", "Madrid", "6.4", 1235L, -280.2, 33.21))
        terremotos.add(Terremoto("3", "Barcelona", "7.4", 1236L, -180.2, 23.21))
        terremotos.add(Terremoto("4", "Sevilla", "8.4", 1237L, -480.2, 213.21))
        terremotos.add(Terremoto("5", "León", "4.4", 1238L, -780.2, 23.2451))
        terremotos.add(Terremoto("1", "Valencia", "5.4", 1234L, -380.2, 6.21))
        terremotos.add(Terremoto("2", "Madrid", "6.4", 1235L, -280.2, 33.21))
        terremotos.add(Terremoto("3", "Barcelona", "7.4", 1236L, -180.2, 23.21))
        terremotos.add(Terremoto("4", "Sevilla", "8.4", 1237L, -480.2, 213.21))
        terremotos.add(Terremoto("5", "León", "4.4", 1238L, -780.2, 23.2451))
        terremotos.add(Terremoto("1", "Valencia", "5.4", 1234L, -380.2, 6.21))
        terremotos.add(Terremoto("2", "Madrid", "6.4", 1235L, -280.2, 33.21))
        terremotos.add(Terremoto("3", "Barcelona", "7.4", 1236L, -180.2, 23.21))
        terremotos.add(Terremoto("4", "Sevilla", "8.4", 1237L, -480.2, 213.21))
        terremotos.add(Terremoto("5", "León", "4.4", 1238L, -780.2, 23.2451))
        terremotos.add(Terremoto("1", "Valencia", "5.4", 1234L, -380.2, 6.21))
        terremotos.add(Terremoto("2", "Madrid", "6.4", 1235L, -280.2, 33.21))
        terremotos.add(Terremoto("3", "Barcelona", "7.4", 1236L, -180.2, 23.21))
        terremotos.add(Terremoto("4", "Sevilla", "8.4", 1237L, -480.2, 213.21))
        terremotos.add(Terremoto("5", "León", "4.4", 1238L, -780.2, 23.2451))

        return terremotos
    }
}
