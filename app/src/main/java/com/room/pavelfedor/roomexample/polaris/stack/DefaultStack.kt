package com.room.pavelfedor.roomexample.polaris.stack

import android.os.Parcelable
import com.room.pavelfedor.roomexample.polaris.tag.Tag
import java.util.*

class DefaultStack : Stack {
    override val items: LinkedList<Parcelable> = LinkedList()
}
