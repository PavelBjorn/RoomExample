package com.room.pavelfedor.roomexample.polaris.tag

import android.os.Parcel
import android.os.Parcelable

class DefaultActivityTag() : Tag {

    constructor(parcel: Parcel) : this() {
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {

    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<DefaultActivityTag> {
        override fun createFromParcel(parcel: Parcel): DefaultActivityTag {
            return DefaultActivityTag(parcel)
        }

        override fun newArray(size: Int): Array<DefaultActivityTag?> {
            return arrayOfNulls(size)
        }
    }

}