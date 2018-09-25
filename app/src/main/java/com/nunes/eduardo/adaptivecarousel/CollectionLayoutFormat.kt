package com.nunes.eduardo.adaptivecarousel

enum class CollectionLayoutFormat(val value: Int) {
    HORIZONTAL(1),
    VERTICAL(2),
    GRID(3),
    HIGHLIGHT(4);

    companion object {
        fun from(findValue: Int): CollectionLayoutFormat = CollectionLayoutFormat.values().first { it.value == findValue }
    }
}