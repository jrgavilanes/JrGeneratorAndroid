package es.codekai.jrgeneratorandroid

import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView

class MyRecyclerAdapter : ListAdapter<Terremoto, MyRecyclerAdapter.MyRecyclerViewHolder>() {

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): MyRecyclerAdapter.MyRecyclerViewHolder {
        // todo captiulo 53. minuto 3:29
    }

    override fun onBindViewHolder(holder: MyRecyclerAdapter.MyRecyclerViewHolder, position: Int){
        // todo
    }

    inner class MyRecyclerViewHolder(val view: View): RecyclerView.ViewHolder(view) {

    }
}
