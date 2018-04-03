package com.room.pavelfedor.roomexample.polaris.tag

import android.os.Parcel
import android.os.Parcelable

class DefaultViewTag() : Tag{

    constructor(parcel: Parcel) : this() {

    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {

    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<DefaultViewTag> {
        override fun createFromParcel(parcel: Parcel): DefaultViewTag {
            return DefaultViewTag(parcel)
        }
        override fun newArray(size: Int): Array<DefaultViewTag?> {
            return arrayOfNulls(size)
        }
    }

}