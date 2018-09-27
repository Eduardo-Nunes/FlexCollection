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

interface CollectionItem {
    val size: Size
}

data class Size(
        val percentage: Float,
        val proportion: Float,
        val fixed: Float
)

class ItemTest (override val size: Size, val title: String) : CollectionItem