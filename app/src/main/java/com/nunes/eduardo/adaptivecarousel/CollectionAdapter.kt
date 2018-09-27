package com.nunes.eduardo.adaptivecarousel

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.collection_item.view.*

class CollectionAdapter(private val myDataset: List<CollectionItem>) :
        RecyclerView.Adapter<CollectionViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup,
                                    viewType: Int): CollectionViewHolder {
        return CollectionViewHolder(LayoutInflater.from(parent.context)
                .inflate(R.layout.collection_item, parent, false))
    }

    override fun onBindViewHolder(holder: CollectionViewHolder, position: Int) {
        holder.bind(myDataset[position])
    }

    override fun getItemCount() = myDataset.size
}

class CollectionViewHolder (itemView: View) : RecyclerView.ViewHolder(itemView) {
    fun bind(item: CollectionItem) = with(itemView) {
        backdropImgView.setImageResource(R.drawable.ic_launcher_background)
        backdropImgView.maxWidth = item.size.fixed
        backdropImgView.minimumWidth = item.size.fixed
        backdropImgView.maxHeight = item.size.fixed * item.size.proportion
        backdropImgView.minimumHeight = item.size.fixed * item.size.proportion
    }
}