package com.room.pavelfedor.roomexample.data.base.api

import com.google.gson.annotations.SerializedName

class Response<Data> {
    @SerializedName("results")
    var data: Data? = null
}
