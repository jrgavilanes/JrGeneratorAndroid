package es.codekai.jrgeneratorandroid

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView

class MyRecyclerAdapter :
    ListAdapter<Terremoto, MyRecyclerAdapter.MyRecyclerViewHolder>(DiffCallback) {

    companion object DiffCallback : DiffUtil.ItemCallback<Terremoto>() {
        override fun areItemsTheSame(oldItem: Terremoto, newItem: Terremoto): Boolean {
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(oldItem: Terremoto, newItem: Terremoto): Boolean {
            return oldItem == newItem
        }
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): MyRecyclerAdapter.MyRecyclerViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.my_list_item, parent, false)
        return MyRecyclerViewHolder(view)
    }

    override fun onBindViewHolder(holder: MyRecyclerAdapter.MyRecyclerViewHolder, position: Int) {
        val terremoto = getItem(position)
        holder.magnitude.text = terremoto.magnitud
        holder.location.text = terremoto.lugar
    }

    inner class MyRecyclerViewHolder(val view: View) : RecyclerView.ViewHolder(view) {
        val magnitude = view.findViewById<TextView>(R.id.txtMagnitude)
        val location = view.findViewById<TextView>(R.id.txtLocation)
    }
}
