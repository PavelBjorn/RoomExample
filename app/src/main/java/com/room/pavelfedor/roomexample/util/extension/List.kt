package com.room.pavelfedor.roomexample.util.extension


fun <Item> MutableList<Item>.replace(items: List<Item>, predicate: (old: Item, new: Item) -> Boolean) {
    items.forEach { newItem -> replace(newItem, { oldItem -> predicate.invoke(oldItem, newItem) }) }
}

fun <Item> MutableList<Item>.replace(item: Item, predicate: (Item) -> Boolean = { it == item }) {
    indexOfFirst(predicate = predicate).let { if (it != -1) set(it, item) }
}
