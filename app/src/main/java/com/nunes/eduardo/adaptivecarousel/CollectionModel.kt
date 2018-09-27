package com.nunes.eduardo.adaptivecarousel

open class CollectionModel(
        var layoutFormat: CollectionLayoutFormat,
        val itemOffset: Float,
        val cellItems: List<CollectionCellModel>
)

class CollectionCellModel(
        val type: String,
        val cellItem: CollectionItem,
        val model: CollectionModel? = null
)

data class Size(
        val percentage: Int,
        val proportion: Int,
        val fixed: Int
)

interface CollectionItem {
    val size: Size
}

class ItemTest (override val size: Size, val title: String) : CollectionItem