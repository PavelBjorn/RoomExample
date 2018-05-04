package com.room.pavelfedor.roomexample.polaris.stack

import android.os.Parcelable
import java.util.*

interface Stack : Parcelable {
    val items: LinkedList<Stack>
}
