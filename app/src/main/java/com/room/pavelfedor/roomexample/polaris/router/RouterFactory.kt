package com.room.pavelfedor.roomexample.polaris.router

import com.room.pavelfedor.roomexample.polaris.tag.Tag

interface RouterFactory {

    fun registerRouter(router: Router<in Tag>)

    fun <T:Tag> makeRouter(tag: Tag):Router<T>
}