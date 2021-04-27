package com.room.pavelfedor.roomexample.util.extension


fun <Item> MutableList<Item>.replace(items: List<Item>, predicate: (old: Item, new: Item) -> Boolean = { old, new -> old == new }) {
    items.forEach { newItem -> replace(newItem, { oldItem -> predicate.invoke(oldItem, newItem) }) }
}

fun <Item> MutableList<Item>.replace(item: Item, predicate: (Item) -> Boolean = { it == item }) = indexOfFirst(predicate = predicate).apply {
    if (this != -1) set(this, item)
}


fun <Item> MutableList<Item>.doSomeShit() = this


fun <Item> MutableList<Item>.doSomeShit2(item: Item, predicate: (Item) -> Boolean = { it == item }) = indexOfFirst(predicate = predicate).apply {
    if (this != -1) set(this, item)

    //Blbablabalbalb
}

fun <Item> MutableList<Item>.doSomeShit3(item: Item, predicate: (Item) -> Boolean = { it == item }) = indexOfFirst(predicate = predicate).apply {
    if (this != -1) set(this, item)
}