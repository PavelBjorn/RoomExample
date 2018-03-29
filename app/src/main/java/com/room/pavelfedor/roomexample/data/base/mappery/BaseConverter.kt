package com.room.pavelfedor.roomexample.data.base.mappery

interface BaseConverter<Source, Target> {
    fun convert(source: Source): Target
}
