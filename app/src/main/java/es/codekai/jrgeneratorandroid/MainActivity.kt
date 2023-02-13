package es.codekai.jrgeneratorandroid

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.GridLayout
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import es.codekai.jrgeneratorandroid.databinding.ActivityMainBinding
import es.codekai.jrgeneratorandroid.databinding.ItemSuperheroBinding

data class SuperHero(
    val superHero: String,
    val publisher: String,
    val realName: String,
    val photo: String
)

val superHeroList = listOf(
    SuperHero(
        "juanra-man1",
        "supu1",
        "juanra1",
        "https://rickandmortyapi.com/api/character/avatar/219.jpeg"
    ),
    SuperHero(
        "juanra-man2",
        "supu2",
        "juanra2",
        "https://rickandmortyapi.com/api/character/avatar/229.jpeg"
    ),
    SuperHero(
        "juanra-man3",
        "supu3",
        "juanra3",
        "https://rickandmortyapi.com/api/character/avatar/239.jpeg"
    ),
    SuperHero(
        "juanra-man4",
        "supu4",
        "juanra4",
        "https://rickandmortyapi.com/api/character/avatar/249.jpeg"
    ),
    SuperHero(
        "juanra-man5",
        "supu5",
        "juanra5",
        "https://rickandmortyapi.com/api/character/avatar/259.jpeg"
    )
)

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        initRecyclerView()
    }

    private fun initRecyclerView() {
        binding.apply {
//            myRecycler.layoutManager = LinearLayoutManager(this@MainActivity)
            myRecycler.layoutManager = GridLayoutManager(this@MainActivity, 2)
            myRecycler.adapter = SuperHeroAdapter(superHeroList) {
                Toast.makeText(this@MainActivity, it.realName, Toast.LENGTH_SHORT).show()
            }
        }
    }
}

class SuperHeroAdapter(private val superHeroes: List<SuperHero>, private val onClickListener: (SuperHero) -> Unit) :
    RecyclerView.Adapter<SuperHeroAdapter.SuperHeroViewHolder>() {

//    Sin ViewBinding
//    inner class SuperHeroViewHolder(view: View) : RecyclerView.ViewHolder(view) {
//        val superHero = view.findViewById<TextView>(R.id.txtSuperHero)
//        val realName = view.findViewById<TextView>(R.id.txtRealName)
//        val publisher = view.findViewById<TextView>(R.id.txtPublisher)
//        val photo = view.findViewById<ImageView>(R.id.imageSuperHero)
//        fun render(superHeroModel: SuperHero) {
//            superHero.text = superHeroModel.superHero
//            realName.text = superHeroModel.realName
//            publisher.text = superHeroModel.publisher
//            Glide.with(photo.context).load(superHeroModel.photo).into(photo)
//        }
//    }

    inner class SuperHeroViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        private val binding = ItemSuperheroBinding.bind(view)
        fun render(superHero: SuperHero, onClickListener: (SuperHero) -> Unit) {
            binding.apply {
                txtSuperHero.text = superHero.superHero
                txtRealName.text = superHero.realName
                txtPublisher.text = superHero.publisher
                Glide.with(binding.root.context).load(superHero.photo).into(imageSuperHero)
                itemView.setOnClickListener {
                    onClickListener(superHero)
                }
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SuperHeroViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        return SuperHeroViewHolder(layoutInflater.inflate(R.layout.item_superhero, parent, false))
    }

    override fun onBindViewHolder(holder: SuperHeroViewHolder, position: Int) {
        holder.render(superHeroes[position], onClickListener)
    }

    override fun getItemCount(): Int = superHeroes.size
}
