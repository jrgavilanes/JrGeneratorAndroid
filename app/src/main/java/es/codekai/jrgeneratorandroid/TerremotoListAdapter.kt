package es.codekai.jrgeneratorandroid

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import es.codekai.jrgeneratorandroid.databinding.MyListItemBinding
import es.codekai.jrgeneratorandroid.models.Terremoto

class TerremotoHolder(val binding: MyListItemBinding) : RecyclerView.ViewHolder(binding.root) {
    fun bind(terremoto: Terremoto, onclickListener: (Terremoto) -> Unit) {
        binding.txtMagnitude.text = terremoto.magnitud
        binding.txtLocation.text = terremoto.lugar
        binding.root.setOnClickListener {
            onclickListener(terremoto)
        }
    }
}

class TerremotoListAdapter(
    private val terremotos: List<Terremoto>,
    private val onclickListener: (Terremoto) -> Unit
) :
    RecyclerView.Adapter<TerremotoHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TerremotoHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = MyListItemBinding.inflate(inflater, parent, false)
        return TerremotoHolder(binding)
    }

    override fun onBindViewHolder(holder: TerremotoHolder, position: Int) {
        val terremoto = terremotos[position]
        holder.bind(terremoto, onclickListener)
    }

    override fun getItemCount() = terremotos.size
}
