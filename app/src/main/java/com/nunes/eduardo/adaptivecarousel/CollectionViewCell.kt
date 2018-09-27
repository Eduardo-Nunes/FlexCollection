package com.nunes.eduardo.adaptivecarousel

import android.view.ViewGroup

open class CollectionViewCell(private val rootView: ViewGroup){

    fun setupView(cell: CollectionModel) {
        if (cell.cellItems.isNotEmpty()) {
            val collection = FlexCollection(rootView.context).apply {
                adapter = MyAdapter(cell.cellItems)
                layoutFormat = cell.layoutFormat
                itemOffset = cell.itemOffset
            }

            if(rootView.childCount != 0) rootView.removeAllViews()
            rootView.addView(collection)
        }
    }

    fun changeLayoutFormat(format: CollectionLayoutFormat){
        (rootView.getChildAt(0) as FlexCollection).layoutFormat = format
    }
}