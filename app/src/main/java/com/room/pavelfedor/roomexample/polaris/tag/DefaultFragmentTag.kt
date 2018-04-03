package com.room.pavelfedor.roomexample.polaris.tag

import android.os.Parcel
import android.os.Parcelable

class DefaultFragmentTag() : Tag{

    constructor(parcel: Parcel) : this() {

    }

    override fun writeToParcel(dest: Parcel?, flags: Int) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun describeContents(): Int {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    companion object CREATOR : Parcelable.Creator<DefaultFragmentTag> {
        override fun createFromParcel(parcel: Parcel): DefaultFragmentTag {
            return DefaultFragmentTag(parcel)
        }

        override fun newArray(size: Int): Array<DefaultFragmentTag?> {
            return arrayOfNulls(size)
        }
    }
}