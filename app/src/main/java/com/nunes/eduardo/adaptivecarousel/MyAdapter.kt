package com.nunes.eduardo.adaptivecarousel

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.collection_item.view.*

class MyAdapter(private val myDataset: List<CollectionCellModel>) :
        RecyclerView.Adapter<MyAdapter.MyViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup,
                                    viewType: Int): MyAdapter.MyViewHolder {
        return MyViewHolder(LayoutInflater.from(parent.context)
                .inflate(R.layout.collection_item, parent, false))
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.bind(myDataset[position].cellItem)
    }

    override fun getItemCount() = myDataset.size

    class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bind(item: CollectionItem) = with(itemView) {
            this.background = context.getDrawable(R.drawable.ic_launcher_background)
            textView.text = (item as ItemTest).title
        }
    }

}