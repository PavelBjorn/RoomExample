package com.room.pavelfedor.roomexample.polaris.stack

import com.room.pavelfedor.roomexample.polaris.tag.Tag
import java.util.*

data class DefaultStack(override val tag: Tag) : Stack {
    override val items: LinkedList<Stack> = LinkedList()
}