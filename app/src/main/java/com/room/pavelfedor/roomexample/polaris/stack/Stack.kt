package com.room.pavelfedor.roomexample.polaris.stack

import com.room.pavelfedor.roomexample.polaris.tag.Tag
import java.util.*

interface Stack {
    val items: LinkedList<Stack>
    val tag: Tag
}