package com.room.pavelfedor.roomexample.polaris.router

import com.room.pavelfedor.roomexample.polaris.tag.Tag

interface Router <T:Tag> {

    fun routeTo(tag:T)

    fun isForTag(tag: T) = geTagClass() == tag::class.java

    fun geTagClass():Class<out T>

    fun compare(router:Router<*>): Boolean
}