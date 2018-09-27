package com.nunes.eduardo.adaptivecarousel

import android.view.ViewGroup

private const val FIRST_VIEW = 0
open class CollectionViewCell(private val rootView: ViewGroup){

    fun setupView(cell: CollectionModel) {
        if (cell.cellItems.isNotEmpty()) {
            rootView.addView(
                    FlexCollection.inflate(rootView.context).apply {
                        layoutFormat = cell.layoutFormat
                        itemOffset = cell.itemOffset
                        adapter = CollectionAdapter(cell.cellItems.map(CollectionCellModel::cellItem))
                    }
            )
        }
    }

    fun changeLayoutFormat(format: CollectionLayoutFormat){
        (rootView.getChildAt(FIRST_VIEW) as FlexCollection).layoutFormat = format
    }
}